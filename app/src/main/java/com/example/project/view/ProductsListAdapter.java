package com.example.project.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListHolder> {
    //proprieties
    private final List<ArticlesImge> productsList;
    private Context context;
    private int itemResource;


    /**
     * constructor
     * @param context
     * @param itemResource
     * @param productsList
     */
    public ProductsListAdapter(Context context, int itemResource, List<ArticlesImge> productsList) {
        this.productsList = productsList;
        this.context = context;
        this.itemResource = itemResource;
    }

    /**
     * update the recycler view
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ProductsListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.itemResource, parent, false);
        return new ProductsListHolder(this.context, view);
    }

    /**
     * give information to parcelable class
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ProductsListHolder holder, int position) {
        // Use position to access the correct place object
        ArticlesImge p = this.productsList.get(position);
        // Bind the place object to the holder
        holder.bindPlace(p);
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return this.productsList.size();
    }


}

