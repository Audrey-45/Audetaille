package com.example.project.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.project.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<GridViewManage> {


    /**
     * constructor
     * @param context
     * @param gVAList
     */
    public GridViewAdapter(@NonNull Context context, ArrayList<GridViewManage> gVAList) {
        super(context, 0, gVAList);
    }

    /**
     * setting the grid view
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.gridview, parent, false);
        }
        GridViewManage gridViewManage = getItem(position);
        TextView tvcolor = listitemView.findViewById(R.id.tvgv);
        ImageView ivcolor = listitemView.findViewById(R.id.imggv);
        tvcolor.setText(gridViewManage.getName());
        ivcolor.setImageResource(gridViewManage.getImg());
        return listitemView;
    }
}
