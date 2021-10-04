package com.example.project.view;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.R;
import com.example.project.controller.Control;
import com.example.project.model.CartArticles;

public class ArticleDetails extends AppCompatActivity {

    private ImageView cart_logo;
    private ImageView cart_logo2;
    private String article;
    private String fav;
    private Control control;


    /**
     * Creation Activity Article Details
     * When we click on an article
     * @param savedInstanceState
     */
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        //get information of the previous page
        ArticlesImge articles =
                (ArticlesImge) getIntent().getParcelableExtra("articles");

        if (articles != null) {
            TextView articleTitle =
                    (TextView) findViewById(R.id.article_title);
            ImageView articlesImage =
                    (ImageView) findViewById(R.id.info_image);
            TextView articlesInfo =
                    (TextView) findViewById(R.id.articles_details);
            TextView articlesprice =
                    (TextView) findViewById(R.id.price);
            TextView articlesnumber =
                    (TextView) findViewById(R.id.num);

            articleTitle.setText(articles.getName());
            articlesImage.setImageResource(articles.getIconId());
            articlesInfo.setText(articles.getInfo());
            articlesprice.setText(Double.toString(articles.getPrice()));

            //Settings all images
            if((articleTitle.getText().toString()).equals("Leaf Cottons"))
            {
                ImageView img1 =
                        (ImageView) findViewById(R.id.info_image);
                img1.setImageResource(R.drawable.leaf1);
                ImageView img2 =
                        (ImageView) findViewById(R.id.info_image2);
                img2.setImageResource(R.drawable.leaf2);
                ImageView img3 =
                        (ImageView) findViewById(R.id.info_image3);
                img3.setImageResource(R.drawable.leaf3);
            }

            if((articleTitle.getText().toString()).equals("Harry Potter Cottons"))
            {
                ImageView img1 =
                        (ImageView) findViewById(R.id.info_image);
                img1.setImageResource(R.drawable.hp1);
                ImageView img2 =
                        (ImageView) findViewById(R.id.info_image2);
                img2.setImageResource(R.drawable.hp2);
                ImageView img3 =
                        (ImageView) findViewById(R.id.info_image3);
                img3.setImageResource(R.drawable.hp3);
            }

            if((articleTitle.getText().toString()).equals("Swallows Cottons"))
            {
                ImageView img1 =
                        (ImageView) findViewById(R.id.info_image);
                img1.setImageResource(R.drawable.sw1);
                ImageView img2 =
                        (ImageView) findViewById(R.id.info_image2);
                img2.setImageResource(R.drawable.sw2);
                ImageView img3 =
                        (ImageView) findViewById(R.id.info_image3);
                img3.setImageResource(R.drawable.sw3);
            }

            if((articleTitle.getText().toString()).equals("Mixed Cottons"))
            {
                ImageView img1 =
                        (ImageView) findViewById(R.id.info_image);
                img1.setImageResource(R.drawable.mx1);
                ImageView img2 =
                        (ImageView) findViewById(R.id.info_image2);
                img2.setImageResource(R.drawable.mx2);
                ImageView img3 =
                        (ImageView) findViewById(R.id.info_image3);
                img3.setImageResource(R.drawable.mx3);
            }

            if((articleTitle.getText().toString()).equals("Heart T-Shirt"))
            {
                ImageView img1 =
                        (ImageView) findViewById(R.id.info_image);
                img1.setImageResource(R.drawable.ts1);
                ImageView img2 =
                        (ImageView) findViewById(R.id.info_image2);
                img2.setImageResource(R.drawable.ts2);
                ImageView img3 =
                        (ImageView) findViewById(R.id.info_image3);
                img3.setImageResource(R.drawable.ts3);
            }

            if((articleTitle.getText().toString()).equals("Bag"))
            {
                ImageView img1 =
                        (ImageView) findViewById(R.id.info_image);
                img1.setImageResource(R.drawable.bag1);
                ImageView img2 =
                        (ImageView) findViewById(R.id.info_image2);
                img2.setImageResource(R.drawable.bag2);
                ImageView img3 =
                        (ImageView) findViewById(R.id.info_image3);
                img3.setImageResource(R.drawable.bag3);
            }
        }

        //when we click on cart logo, the article is add in the database
        this.control = Control.getInstance(this);
        this.cart_logo = findViewById(R.id.cart_logo);
        this.cart_logo.setOnClickListener((view) ->
        {
            article = articles.getName();
            Toast.makeText(getApplicationContext(), article + " is add to your cart", Toast.LENGTH_SHORT).show();
            // editArticle = (TextView) findViewById(R.id.editArticle);
            // rajouter le nom de l'article

            saveArticle(article);
        });

        //when we click on fav logo, the article is add in the database
        this.control = Control.getInstance(this);
        this.cart_logo2 = findViewById(R.id.cart_logo2);
        this.cart_logo2.setOnClickListener((view) ->
        {
            fav = articles.getName();
            Toast.makeText(getApplicationContext(), fav + " saved in your favorite", Toast.LENGTH_SHORT).show();
            // editArticle = (TextView) findViewById(R.id.editArticle);
            // rajouter le nom de l'article

            saveFavArticle(fav);

        });
    }


    /**
     * save article in database
     * @param article
     */
    private void saveArticle(String article)
    {
        this.control.addCart(article);
    }

    /**
     * save fav in database
     * @param fav
     */
    private void saveFavArticle(String fav)
    {
        this.control.addFavorite(fav);
    }



}
