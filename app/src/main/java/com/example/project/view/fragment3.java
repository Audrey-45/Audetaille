package com.example.project.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.controller.Control;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
//Create the custom t-shirt

public class fragment3 extends Fragment {

    //proprieties
    private Control control;
    private String color;
    private String size;
    private String name;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment3 newInstance(String param1, String param2) {
        fragment3 fragment = new fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Creation parameters
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
     * Creation Activité fragment 3
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View gdview = inflater.inflate(R.layout.fragment_fragment3, container, false);
        this.control = Control.getInstance(getActivity().getApplicationContext());
        GridView colorGV;

        colorGV = (GridView) gdview.findViewById(R.id.gdColor);

        //choose the color of t-shirt in a gridView
        ArrayList<GridViewManage> colorArrayList = new ArrayList<GridViewManage>();
        colorArrayList.add(new GridViewManage("BLACK", R.drawable.black));
        colorArrayList.add(new GridViewManage("WHITE", R.drawable.white));
        colorArrayList.add(new GridViewManage("BLUE", R.drawable.blue));
        colorArrayList.add(new GridViewManage("RED", R.drawable.red));

        GridViewAdapter adapter = new GridViewAdapter(getActivity().getApplicationContext(), colorArrayList);
        colorGV.setAdapter(adapter);
        // Implement On Item click listener
        colorGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * grid view clikable to choose the good color
             * 4 images are present in this grid
             * Images of tshirt with each of the color
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Toast.makeText(getContext(), "You choose BLACK color ", Toast.LENGTH_SHORT).show();
                        color = "BLACK";
                        break;
                    case 1:
                        Toast.makeText(getContext(), "You choose WHITE color ", Toast.LENGTH_SHORT).show();
                        color = "WHITE";
                        break;
                    case 2:
                        Toast.makeText(getContext(), "You choose BLUE color ", Toast.LENGTH_SHORT).show();
                        color = "BLUE";
                        break;
                    case 3:
                        Toast.makeText(getContext(), "You choose RED color ", Toast.LENGTH_SHORT).show();
                        color = "RED";
                        break;
                }
            }
        });



        Button buttonS = (Button) gdview.findViewById(R.id.btS);
        buttonS.setOnClickListener(new View.OnClickListener() {
            /**
             * button to choose the size S
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "S is selected", Toast.LENGTH_SHORT).show();
                size = "S";
            }
        });


        Button buttonM = (Button) gdview.findViewById(R.id.btM);
        buttonM.setOnClickListener(new View.OnClickListener() {
            /**
             * button to choose the size M
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "M is selected", Toast.LENGTH_SHORT).show();
                size = "M";
            }
        });


        Button buttonL = (Button) gdview.findViewById(R.id.btL);
        buttonL.setOnClickListener(new View.OnClickListener() {
            /**
             * button to choose the size L
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "L is selected", Toast.LENGTH_SHORT).show();
                size = "L";
            }
        });


        //edit text to enter the name of the logo embroidered
        EditText eTName = (EditText) gdview.findViewById(R.id.tSName);

        Button nameButton = (Button) gdview.findViewById(R.id.btName);
        nameButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Button for validate the name of the logo for the tshirt
             * @param v
             */
            public void onClick(View v) {

                Toast.makeText(getContext(), eTName.getText().toString() + " WILL BE EMBROIDERED", Toast.LENGTH_SHORT).show();
                name = eTName.getText().toString();
            }

        });

        //button to finalize the order, and add the t-shirt in wamp
        Button buyButton = (Button) gdview.findViewById(R.id.btBuyTS);
        buyButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button for valide all
             * Check is all informations have been selected
             * @param v
             */
            public void onClick(View v) {

                if(color!=null&&size!=null&&name!=null)
                {
                    control.AddTshirt(color, size, name);
                    Toast.makeText(getContext(), "THANK YOU FOR YOUR ORDER", Toast.LENGTH_LONG).show();
                    Intent gameActivtyIntent=new Intent(getActivity(), MainActivity.class);
                    startActivity(gameActivtyIntent);
                }
                else
                {
                    Toast.makeText(getContext(), "INFORMATION IS MISSING", Toast.LENGTH_LONG).show();
                }

            }

        });

        return gdview;
    }



}