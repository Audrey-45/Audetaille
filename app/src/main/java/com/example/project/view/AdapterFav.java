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
import com.example.project.model.Favorite;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdapterFav extends RecyclerView.Adapter<AdapterFav.MyViewHolder>{

    //proprieties
    private ArrayList<ArticlesImg> articlesList;
    private LayoutInflater inflater;
    private Control control;
    private Context context;

    public AdapterFav(Context context, ArrayList<ArticlesImg> articlesList) {
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
        View view = inflater.inflate(R.layout.activity_articles_fav, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    /**
     * get numbers of items
     * @return articlesList.size()
     */
    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    /**
     * set information
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ArticlesImg current = articlesList.get(position);
        //update informations
        holder.setData(current, position);
        holder.setListeners();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgDelete;
        private TextView articlesPrice;
        private TextView articlesNumber;
        private TextView articlesName;
        private ImageView articleImg;
        private ImageView imgAdd;
        private int position;
        private ArticlesImg currentObject;

        /**
         * Add information in the recycler view and use it
         * @param itemView
         */
        public MyViewHolder(View itemView) {
            super(itemView);

            articleImg = (ImageView) itemView.findViewById(R.id.img_article_one);
            articlesName = (TextView) itemView.findViewById(R.id.title_article_one);
            articlesPrice = (TextView) itemView.findViewById(R.id.price_one);
            articlesNumber = (TextView) itemView.findViewById(R.id.num_one);
            imgDelete = (ImageView) itemView.findViewById(R.id.delete_fav);
            imgAdd = (ImageView) itemView.findViewById(R.id.add_cart);


            itemView.setOnClickListener(new View.OnClickListener() {
                /**
                 * click on an item in the recycler view
                 * @param v
                 */
                @Override
                public void onClick(View v) {
                }
            });
        }


        /**
         * get name
         * @param currentObject
         * @param position
         * @return
         */
        public String getName(ArticlesImg currentObject, int position) {
            return currentObject.getName();
        }

        /**
         * set all data
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

        /**
         * set the item images
         */
        public void setListeners() {
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);
        }

        /**
         * settings of click on trash or cart
         * @param v
         */
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //delete fav when user click on the trash
                case R.id.delete_fav:
                    removeItem(position, itemView);
                    break;
                case R.id.add_cart:
                    removeAddItem(position, itemView);
                    break;
            }
        }
    }


    /**
     * remove article
     * @param position
     * @param itemView
     */
    public void removeItem(int position, View itemView) {
        this.control = Control.getInstance(this.context);
        ArrayList<Favorite> listFavArticles = control.getAllFavorites();

        //search for fav in database
        int id =0;
        for(int i=0; i<listFavArticles.size(); i++)
        {
            for(int j=0; j<articlesList.size(); j++)
            {
                if(listFavArticles.get(i).getFav().equals(articlesList.get(j).getName()))
                {
                    id++;
                }
            }

        }

        Favorite favorite = new Favorite(articlesList.get(position).getName(), id-1);
        //delete fav in wamp
        control.delFav(favorite, position);
        articlesList.remove(position);

        notifyItemRemoved(position);
        notifyItemRangeChanged(position, articlesList.size());

        Intent intent=new Intent(itemView.getContext(), FavoriteProducts.class);
        itemView.getContext().startActivity(intent);

    }


    /**
     * remove article article from favorite and add to the fav
     * @param position
     * @param itemView
     */
    public void removeAddItem(int position, View itemView) {
        this.control = Control.getInstance(this.context);
        ArrayList<Favorite> listFavArticles = control.getAllFavorites();

        //search for fav in database
        int id =0;
        for(int i=0; i<listFavArticles.size(); i++)
        {
            for(int j=0; j<articlesList.size(); j++)
            {
                if(listFavArticles.get(i).getFav().equals(articlesList.get(j).getName()))
                {
                    id++;
                }
            }

        }
        Favorite favorite = new Favorite(articlesList.get(position).getName(), id-1);
        //delete fav in wamp
        control.delFav(favorite, position);
        //add in cart
        control.addCart(articlesList.get(position).getName());
        articlesList.remove(position);

        notifyItemRemoved(position);
        notifyItemRangeChanged(position, articlesList.size());

        Intent intent=new Intent(itemView.getContext(), FavoriteProducts.class);
        itemView.getContext().startActivity(intent);

    }


}