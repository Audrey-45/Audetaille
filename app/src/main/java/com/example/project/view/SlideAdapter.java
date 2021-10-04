package com.example.project.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.project.R;

import java.util.List;

//settings of the view pager auto scroll
public class SlideAdapter extends PagerAdapter {
    private int[] img_id={R.drawable.bag1, R.drawable.bag2, R.drawable.bag3};
    private Context context;
    private LayoutInflater layoutInflater;

    /**
     * constructor
     * @param context
     */
    public SlideAdapter(Context context)
    {
        this.context = context;
    }

    /**
     * get count of number of images
     * @return
     */
    @Override
    public int getCount() {
        return img_id.length;
    }

    /**
     * return layout linear for the view
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout) object);
    }

    /**
     * instante item
     * @param container
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_slide);
        imageView.setImageResource(img_id[position]);

        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view,0);
        return view;
    }

    /**
     * destroy item
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        container.removeView(view);
    }
}
