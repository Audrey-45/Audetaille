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

public class AdapterTs extends RecyclerView.Adapter<AdapterTs.MyViewHolder>{

    //proprietes
    private ArrayList<TSImge> articlesList;
    private LayoutInflater inflater;
    private Control control;
    private Context context;


    /**
     * Add to the cart the custom t-shirt
     * @param context
     * @param articlesList
     */
    public AdapterTs(Context context, ArrayList<TSImge> articlesList) {
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
        View view = inflater.inflate(R.layout.activity_articles_ts, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    /**
     * get numbers of item of the recycler view
     * @return articlesList.size()
     */
    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    /**
     * set all information of the recycler view
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TSImge current = articlesList.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //proprieties
        private ImageView imgDelete;
        private TextView tSPrice;
        private TextView tSName;
        private TextView tSColor;
        private TextView tSSize;
        private TextView tSLogo;
        private ImageView articleImg;
        private int position;
        private TSImge currentObject;

        /**
         * declaration of all parameters
         * @param itemView
         */
        public MyViewHolder(View itemView) {
            super(itemView);
            articleImg = (ImageView) itemView.findViewById(R.id.img_ts);
            tSName = (TextView) itemView.findViewById(R.id.title_ts);
            tSColor = (TextView) itemView.findViewById(R.id.color_ts);
            tSSize = (TextView) itemView.findViewById(R.id.size_ts);
            tSLogo = (TextView) itemView.findViewById(R.id.logo_ts);
            tSPrice = (TextView) itemView.findViewById(R.id.price_ts);
            imgDelete = (ImageView) itemView.findViewById(R.id.delete_ts);


            itemView.setOnClickListener(new View.OnClickListener() {
                /**
                 * if we click on an item of the Recycler View
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
        public String getName(TSImge currentObject, int position) {
            return currentObject.getName();
        }

        /**
         * set all the data
         * @param currentObject
         * @param position
         */
        public void setData(TSImge currentObject, int position) {
            this.tSName.setText(currentObject.getName());
            this.tSPrice.setText(Double.toString(currentObject.getPrice()));
            this.tSColor.setText(currentObject.getColor());
            this.tSSize.setText(currentObject.getSize());
            this.tSLogo.setText(currentObject.getLogo());
            this.articleImg.setImageResource(currentObject.getIconId());
            this.position = position;
            this.currentObject = currentObject;
        }

        /**
         * set the trash item
         */
        public void setListeners() {
            imgDelete.setOnClickListener(MyViewHolder.this);
        }

        /**
         * setting of item trash
         * @param v
         */
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.delete_ts:
                    removeItem(position, itemView);
                    break;
            }
        }
    }

    /**
     * click cart and remove tshirt
     * @param position
     * @param itemView
     */
    public void removeItem(int position, View itemView) {
        this.control = Control.getInstance(this.context);
        ArrayList<CartArticles> listCartArticles = control.getAllArticles();
        ArrayList<Ticket> listTshirt = control.getAllTshirt();
        Ticket ticket = new Ticket(articlesList.get(position).getColor(), articlesList.get(position).getSize(),
                articlesList.get(position).getLogo());

        control.delTs(ticket, position);
        articlesList.remove(position);

        notifyItemRemoved(position);
        notifyItemRangeChanged(position, articlesList.size());

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