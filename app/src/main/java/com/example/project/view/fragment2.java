package com.example.project.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.project.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */


//show four categories
public class fragment2 extends Fragment {

    private Button button;
    private Context context;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment2 newInstance(String param1, String param2) {
        fragment2 fragment = new fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Creation two parameters
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
     * Creation Activité fragment 2
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
         View rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);


        button = (Button) rootView.findViewById(R.id.Button_Cottons);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * click button to open Main Activity
             * button to go the fragment 1
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Cottons are clicked", Toast.LENGTH_SHORT).show();
                Intent gameActivtyIntent=new Intent(getActivity(), MainActivity.class);
                startActivity(gameActivtyIntent);
            }
        });


        button = (Button) rootView.findViewById(R.id.Button_TeeShirts);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * button to go to the fragment 3
             * click button to open Customs items
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Tee-Shirts are clicked", Toast.LENGTH_SHORT).show();
                Intent gameActivtyIntent=new Intent(getActivity(), fragment3.class);
                startActivity(gameActivtyIntent);
            }
        });

        button = (Button) rootView.findViewById(R.id.Button_LimitedEdition);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * button to go to the fragment 4
             * click button to open Limited Edition
             * @param view
             */
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Limited Edition is clicked", Toast.LENGTH_SHORT).show();
                Intent gameActivtyIntent=new Intent(getActivity(), fragment4.class);
                startActivity(gameActivtyIntent);
            }
        });


        button = (Button) rootView.findViewById(R.id.Button_All);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * button to go the fragment 1
             * click button to open Main Activity
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "All is clicked", Toast.LENGTH_SHORT).show();
                Intent gameActivtyIntent=new Intent(getActivity(), MainActivity.class);
                startActivity(gameActivtyIntent);
            }
        });

        return rootView;


    }
}