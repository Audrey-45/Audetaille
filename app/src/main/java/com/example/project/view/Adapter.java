package com.example.project.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.controller.Control;
import com.example.project.model.CartArticles;
import com.example.project.model.Ticket;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    //proprieties
    private ArrayList<ArticlesImg> articlesList;
    private LayoutInflater inflater;
    private Control control;
    private Context context;


    //Adapter to show informations of wamp in the Cart
    public Adapter(Context context, ArrayList<ArticlesImg> articlesList) {
        inflater = LayoutInflater.from(context);
        this.articlesList = articlesList;
        this.control = Control.getInstance(context);

    }

    /**
     * Creation of the recycler view
     * @param parent
     * @param viewType
     * @return holder
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_articles_cart, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    /**
     * get item count
     * @return articleList.size()
     */
    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    /**
     * set all information with position
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ArticlesImg current = articlesList.get(position);
        //update
        holder.setData(current, position);
        holder.setListeners();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        //properties
        private ImageView imgDelete;
        private TextView articlesPrice;
        private TextView articlesNumber;
        private TextView articlesName;
        private ImageView articleImg;
        private int position;
        private ArticlesImg currentObject;

        /**
         * define each parameter
         * @param itemView
         */
        public MyViewHolder(View itemView) {
            super(itemView);

            articleImg = (ImageView) itemView.findViewById(R.id.img_article_one);
            articlesName = (TextView) itemView.findViewById(R.id.title_article_one);
            articlesPrice = (TextView) itemView.findViewById(R.id.price_one);
            articlesNumber = (TextView) itemView.findViewById(R.id.num_one);
            imgDelete = (ImageView) itemView.findViewById(R.id.delete_one);


            itemView.setOnClickListener(new View.OnClickListener() {
                /**
                 * Click on an item of the recycler view
                 * @param v
                 */
                @Override
                public void onClick(View v) {
                }
            });
        }


        /**
         * get Name
         * @param currentObject
         * @param position
         * @return
         */
        public String getName(ArticlesImg currentObject, int position) {
            return currentObject.getName();
        }

        /**
         * set all data of the Recycler View
         * @param currentObject
         * @param position
         */
        public void setData(ArticlesImg currentObject, int position) {
            this.articlesName.setText(currentObject.getName());
            this.articlesPrice.setText(Double.toString(currentObject.getPrice()));
            this.articlesNumber.setText(currentObject.getNumber());
            this.articleImg.setImageResource(currentObject.getIconId());
            this.position = position;
            this.currentObject = currentObject;
        }

        public void setListeners() {
            imgDelete.setOnClickListener(MyViewHolder.this);
        }

        /**
         * check if item trash is click or not
         * @param v
         */
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //when user click on the trash, article is delete in cart
                case R.id.delete_one:
                    removeItem(position, itemView);
                break;
            }
        }
    }



    /**
     * function to delete article in the recycler view
     * and also in wamp
     * @param position
     * @param itemView
     */
    public void removeItem(int position, View itemView) {
        this.control = Control.getInstance(this.context);
        ArrayList<CartArticles> listCartArticles = control.getAllArticles();
        ArrayList<Ticket> listTshirt = control.getAllTshirt();

        //search for articles in database
        int id =0;
        for(int i=0; i<listCartArticles.size(); i++)
        {
            for(int j=0; j<articlesList.size(); j++)
            {
                if(listCartArticles.get(i).getArticleCart().equals(articlesList.get(j).getName()))
                {
                    id++;
                }
            }

        }

        CartArticles cartArticles = new CartArticles(articlesList.get(position).getName(), id-1);

        //function to delete in the database
        control.delCart(cartArticles, position);
        articlesList.remove(position);

        notifyItemRemoved(position);
        notifyItemRangeChanged(position, articlesList.size());

        //Show page empty of cart if their no articles
        if((listCartArticles.size()+listTshirt.size())<1)
        {
            Intent intent=new Intent(itemView.getContext(), CartEmpty.class);
            itemView.getContext().startActivity(intent);
        }
        else
        {
            Intent intent=new Intent(itemView.getContext(), Cart.class);
            itemView.getContext().startActivity(intent);
        }

    }




}