package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.controller.Control;
import com.example.project.model.CartArticles;
import com.example.project.model.Ticket;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    //proprieties
    private RecyclerView productsListView;
    private RecyclerView tSListView;
    private ArrayList<ArticlesImg> articlesImg;
    private ArrayList<TSImge> tsImg;
    private Control control;
    private static Context context;
    private Integer numLeaf=0;
    private Integer numSwallows=0;
    private Integer numHp=0;
    private Integer numMx=0;
    private Integer numTs=0;
    private Integer numBag=0;
    private Double total=0.0;
    private ImageView delete;


    /**
     * Creation of Activity Cart
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        this.control = Control.getInstance(this);


        // get the data of article in wamp
        loadArticles();


        //show in the first Recycler View the articles add in the cart
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.articles_list_one);
        Adapter adapter = new Adapter(this, articlesImg);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        //get the data of tshirt in wamp
        cartTS();

        //show in the first Recycler View the custom tshirt add in the cart
        RecyclerView recyclerViewTs = (RecyclerView) findViewById(R.id.articles_list_ts);
        AdapterTs adapterTs = new AdapterTs(this, tsImg);
        recyclerViewTs.setAdapter(adapterTs);
        LinearLayoutManager layoutManagerTs = new LinearLayoutManager(this);
        layoutManagerTs.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewTs.setLayoutManager(layoutManagerTs);
        recyclerViewTs.setItemAnimator(new DefaultItemAnimator());


        //show total
        TextView tot = (TextView) findViewById(R.id.total);
        tot.setText(total.toString());


        //button to pay
        Button butPay = (Button) findViewById(R.id.pay);
        butPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "THANKS FOR YOUR ORDER. LET'S PAY", Toast.LENGTH_LONG).show();
            }
        });

    }

    /**
     * Load article if it is in the database
     */
    @SuppressLint("SetTextI18n")
    private void loadArticles() {
        articlesImg = new ArrayList<ArticlesImg>();
        ArrayList<ArticlesImg> allArticles = new ArrayList<ArticlesImg>();
        ArrayList<CartArticles> listCartArticles = control.getAllArticles();

        ArticlesImg leafAll = new ArticlesImg(
                "Leaf Cottons",
                R.drawable.leaf1,
                "",9.9, numLeaf.toString());
        ArticlesImg hpAll = new ArticlesImg(
                "Harry Potter Cottons",
                R.drawable.hp1,
                "",9.9, numHp.toString());
        ArticlesImg swallowsAll = new ArticlesImg(
                "Swallows Cottons",
                R.drawable.sw1,
                "", 9.9, numSwallows.toString());
        ArticlesImg mixedCottonsAll = new ArticlesImg(
                "Mixed Cottons",
                R.drawable.mx1,
                "", 9.9, numMx.toString());
        ArticlesImg tshirtAll = new ArticlesImg(
                "Heart T-Shirt",
                R.drawable.ts1,
                "", 18, numTs.toString());
        ArticlesImg bagAll = new ArticlesImg(
                "Bag",
                R.drawable.bag1,
                "", 24, numBag.toString());

        //Search same fave to show just one image and after write the number of same articles
        for(int i=0; i<listCartArticles.size(); i++)
        {
            if ((listCartArticles.get(i).getArticleCart()).equals("Leaf Cottons"))
            {
                numLeaf++;
                allArticles.add(leafAll);
            }
            if (listCartArticles.get(i).getArticleCart().equals("Harry Potter Cottons"))
            {
                numHp++;
                allArticles.add(hpAll);
            }
            if (listCartArticles.get(i).getArticleCart().equals("Swallows Cottons"))
            {
                numSwallows++;
                allArticles.add(swallowsAll);
            }
            if (listCartArticles.get(i).getArticleCart().equals("Mixed Cottons"))
            {
                numMx++;
                allArticles.add(mixedCottonsAll);
            }
            if (listCartArticles.get(i).getArticleCart().equals("Heart T-Shirt"))
            {
                numTs++;
                allArticles.add(tshirtAll);
            }
            if (listCartArticles.get(i).getArticleCart().equals("Bag"))
            {
                numBag++;
                allArticles.add(bagAll);
            }
        }

        for(int i=0; i<allArticles.size(); i++)
        {
            total = total + allArticles.get(i).getPrice();
        }


        ArticlesImg leaf = new ArticlesImg(
                "Leaf Cottons",
                R.drawable.leaf1,
                "",9.9, numLeaf.toString());
        ArticlesImg hp = new ArticlesImg(
                "Harry Potter Cottons",
                R.drawable.hp1,
                "",9.9, numHp.toString());
        ArticlesImg swallows = new ArticlesImg(
                "Swallows Cottons",
                R.drawable.sw1,
                "", 9.9, numSwallows.toString());
        ArticlesImg mixedCottons = new ArticlesImg(
                "Mixed Cottons",
                R.drawable.mx1,
                "", 9.9, numMx.toString());
        ArticlesImg tshirt = new ArticlesImg(
                "Heart T-Shirt",
                R.drawable.ts1,
                "", 18, numTs.toString());
        ArticlesImg bag = new ArticlesImg(
                "Bag",
                R.drawable.bag1,
                "", 24, numBag.toString());


        if(numLeaf>=1)
        {
            articlesImg.add(leaf);
        }
        if(numHp>=1)
        {
            articlesImg.add(hp);
        }
        if(numSwallows>=1)
        {
            articlesImg.add(swallows);
        }
        if(numMx>=1)
        {
            articlesImg.add(mixedCottons);
        }
        if(numTs>=1)
        {
            articlesImg.add(tshirt);
        }
        if(numBag>=1)
        {
            articlesImg.add(bag);
        }
    }


    /**
     * load customs tshirt add in fragment 3
     */
    private void cartTS()
    {
        tsImg = new ArrayList<TSImge>();
        ArrayList<Ticket> listTS = control.getAllTshirt();

        for(int i=0; i<listTS.size(); i++) {

            TSImge tshirt = new TSImge(
                    "Custom t-shirt",
                    R.drawable.ts3, 30, listTS.get(i).getColor(),
                    listTS.get(i).getSize(), listTS.get(i).getName());
            tsImg.add(tshirt);

            total = total + tsImg.get(i).getPrice();
        }

    }





}