package com.example.project.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;


public class ProductsListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //proprieties
    private final ImageView articleImg;
    private final TextView articlesName;
    private final TextView articlesPrice;
    private final TextView articlesNumber;
    private ArticlesImge productsList;
    private Context context;

    /**
     * constructor
     * @param context
     * @param itemView
     */
    public ProductsListHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;
        this.articleImg = (ImageView) itemView.findViewById(R.id.article_img);
        this.articlesName = (TextView) itemView.findViewById(R.id.title_article);
        this.articlesPrice = (TextView) itemView.findViewById(R.id.price);
        this.articlesNumber = (TextView) itemView.findViewById(R.id.num);

        itemView.setOnClickListener(this);
    }

    /**
     * set information with product list get
     * @param productsList
     */
    public void bindPlace(ArticlesImge productsList) {
        // Bind the data to the ViewHolder
        this.productsList = productsList;
        this.articlesName.setText(productsList.getName());
        this.articlesPrice.setText(Double.toString(productsList.getPrice()));
        this.articlesNumber.setText(productsList.getNumber());
        this.articleImg.setImageDrawable(this.context.getResources().getDrawable(productsList.getIconId()));
    }

    /**
     * click on article to open the class articles details
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (this.productsList != null) {
            Intent intent = new Intent(itemView.getContext(), ArticleDetails.class);
            intent.putExtra("articles", this.productsList);
            itemView.getContext().startActivity(intent);
        }
    }
}


