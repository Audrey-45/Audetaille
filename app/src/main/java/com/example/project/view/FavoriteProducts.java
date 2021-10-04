package com.example.project.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.controller.Control;
import com.example.project.model.CartArticles;
import com.example.project.model.Favorite;
import com.example.project.model.Tshirt;

import java.util.ArrayList;


//show fav add

public class FavoriteProducts extends AppCompatActivity {

    //proprieties
    private ArrayList<ArticlesImg> articlesImg;
    private Control control;
    private static Context context;
    private Integer numLeaf=0;
    private Integer numSwallows=0;
    private Integer numHp=0;
    private Integer numMx=0;
    private Integer numTs=0;
    private Integer numBag=0;

    /**
     * Cretion Activity Favorite
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_products);
        this.control = Control.getInstance(this);

        // get the data fav in wamp
        loadArticles();

        //show Recycler view of fav articles
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.articles_list_fav);
        AdapterFav adapter = new AdapterFav(this, articlesImg);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    /**
     * load all information about an article
     * Check if this article is or not in the database for load it or not
     */
    @SuppressLint("SetTextI18n")
    private void loadArticles() {
        articlesImg = new ArrayList<ArticlesImg>();
        ArrayList<Favorite> listCartArticles = control.getAllFavorites();


        //Search same fave to show just one image and after write the number of same articles
        for(int i=0; i<listCartArticles.size(); i++)
        {
            if ((listCartArticles.get(i).getFav()).equals("Leaf Cottons"))
            {
                numLeaf++;
            }
            if (listCartArticles.get(i).getFav().equals("Harry Potter Cottons"))
            {
                numHp++;
            }
            if (listCartArticles.get(i).getFav().equals("Swallows Cottons"))
            {
                numSwallows++;
            }
            if (listCartArticles.get(i).getFav().equals("Mixed Cottons"))
            {
                numMx++;
            }
            if (listCartArticles.get(i).getFav().equals("Heart T-Shirt"))
            {
                numTs++;
            }
            if (listCartArticles.get(i).getFav().equals("Bag"))
            {
                numBag++;
            }
        }

        //settings of articles
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




}