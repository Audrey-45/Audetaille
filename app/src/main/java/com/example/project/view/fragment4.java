package com.example.project.view;
import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment4#newInstance} factory method to
 * create an instance of this fragment.
 */

//show the tote bag
public class fragment4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //proprieties
    private ViewPager viewPager;
    private TextView textView;
    private List<Slide> slideList = new ArrayList<Slide>();
    private int current_position = 0;

    public fragment4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment4 newInstance(String param1, String param2) {
        fragment4 fragment = new fragment4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Creation if this two parameters
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * Creation Activity fragment 4 with the viewPage
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View scrollview = inflater.inflate(R.layout.fragment_fragment4, container, false);
        textView = (TextView) scrollview.findViewById(R.id.info_bag);
        textView.setText("Handmade reversible tote bag.\n" +
                "Handcrafted with recycled fabrics, this reversible tote bag can be used as one of those you can find on the market: handbag, sports bag ... as you wish!\n" +
                "\n" +
                "A midnight blue side with a moon motif, a white side with a mountain motif.");


        //creation of a view pager auto scroll
        viewPager = (ViewPager) scrollview.findViewById(R.id.viewpager);
        SlideAdapter slideAdapter = new SlideAdapter(getActivity());

        viewPager.setAdapter(slideAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 1500, 4000);

        return scrollview;

    }

    public class MyTimerTask extends TimerTask{

        /**
         * creation timer, and change image
         */
        @Override
        public void run() {

            fragment4.this.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0)
                    {
                        viewPager.setCurrentItem(1);
                    }
                    else if(viewPager.getCurrentItem()==1)
                    {
                        viewPager.setCurrentItem(2);
                    }
                    else
                    {
                        viewPager.setCurrentItem(0);
                    }
                }
            });


        }
    }

}
