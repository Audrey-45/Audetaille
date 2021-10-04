package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CartEmpty extends AppCompatActivity {

    //if the cart is empty this activity appears


    /**
     * Activity if their are no article in the cart
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_empty);

        Button emptyBt = (Button) findViewById(R.id.buy_now);
        emptyBt.setOnClickListener(new View.OnClickListener()
        {
            /**
             * button to go to the fragment 1 to go shopping
             * @param v
             */
            @Override
            public void onClick (View v){
                Toast.makeText(getApplicationContext(), "Start Shopping", Toast.LENGTH_SHORT).show();
                Intent gameActivtyIntent=new Intent(CartEmpty.this, MainActivity.class);
                startActivity(gameActivtyIntent);
            }
        });

    }



}