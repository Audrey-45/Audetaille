package com.example.project.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView productsListView;
    private ArrayList<ArticlesImge> articlesImg;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment1 newInstance(String param1, String param2) {
        fragment1 fragment = new fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Creation 2 parameters
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
     * Creation Activity fragment 1
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);
        // 1. get a reference to recyclerView
        productsListView = (RecyclerView) rootView.findViewById(R.id.articles_list);
        // if the recyclerview doesn't change size, we can set this true and
        productsListView.setHasFixedSize(true);

        // get the data
        loadArticles();

        // Initialize the Placesion of items and  adapter, which binds the data to the entry view
        ProductsListAdapter adapter = new ProductsListAdapter(getActivity().getApplicationContext(), R.layout.activity_articles, articlesImg);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        productsListView.setLayoutManager(layoutManager);
        productsListView.setAdapter(adapter);

        return rootView;
    }


    //settings articles with information about each of them
    private void loadArticles() {
        articlesImg = new ArrayList<ArticlesImge>();

        ArticlesImge leaf = new ArticlesImge(
                "Leaf Cottons",
                R.drawable.leaf1,
                "7 reusable bamboo fiber Cottons.\n" +
                        "We sell 7 reusable Cottons with the Leaf pattern.\n" +
                        "Make a gesture for the planet. These Cottons are machine washable, unlike simple Cottons that are thrown in the trash.\n"+
                        "These Cottons are handmade, 100% organic and 100% ecological!",9.9, "");
        ArticlesImge hp = new ArticlesImge(
                "Harry Potter Cottons",
                R.drawable.hp1,
                "Pack of 7 reusable bamboo fiber Cottons.\n" +
                        "We sell 7 reusable Cottons .\n" +
                        "These Cottons are very soft and respectful of nature.\n" +
                        "We made them by hand with love.\n" +
                        "These Cottons are handmade, 100% organic and 100% ecological!\n" +
                        "Enjoy <3",9.9, "");
        ArticlesImge swallows = new ArticlesImge(
                "Swallows Cottons",
                R.drawable.sw1,
                "7 Reusable cottons, Swallow pattern.\n"+
                        "No need to throw them in the trash anymore. Machine them and do a good deed for the planet.\n"+
                        "These Cottons are handmade, 100% organic and 100% ecological!", 9.9, "");
        ArticlesImge mixedCottons = new ArticlesImge(
                "Mixed Cottons",
                R.drawable.mx1,
                "Set of 7 reusable bamboo fiber Cottons. \n" +
                        "We present to you these packs of 7 reusable Cottons. \n" +
                        "No need to throw them in the trash anymore! Machine them and do a good deed for the planet.\n" +
                        "\n" +
                        "Three patterns available, identical lots or in bulk, it's up to you!\n" +
                        "- Swallows\n" +
                        "- Leaf\n" +
                        "- Harry Potter\n" +
                        "\n" +
                        "These Cottons are handmade, 100% organic and 100% ecological!", 9.9, "");
        ArticlesImge tshirt = new ArticlesImge(
                "Heart T-Shirt",
                R.drawable.ts1,
                "This heart motif t-shirt is hand embroidered by us.\n" +
                        "The t-shirt is blue. Its size is one-size-fits-all.\n" +
                        "100% organic and eco-responsible.", 18, "");
        ArticlesImge bag = new ArticlesImge(
                "Bag",
                R.drawable.bag1,
                "Handmade reversible tote bag.\n" +
                        "Handcrafted with recycled fabrics, this reversible tote bag can be used as one of those you can find on the market: handbag, sports bag ... as you wish!\n" +
                        "\n" +
                        "A midnight blue side with a moon motif, a white side with a mountain motif.", 24, "");

        articlesImg.add(leaf);
        articlesImg.add(hp);
        articlesImg.add(swallows);
        articlesImg.add(mixedCottons);
        articlesImg.add(tshirt);
        articlesImg.add(bag);
    }
}

