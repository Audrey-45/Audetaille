package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AccountMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_main);

        //Already existing account
        Button registeredButton = (Button) findViewById(R.id.registered);
        registeredButton.setOnClickListener(new View.OnClickListener() {
            /**
             * click on this button if you have already save an account
             * @param v
             */
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Welcome to AUDETAILLE", Toast.LENGTH_LONG).show();
                Intent gameActivtyIntent=new Intent(AccountMain.this, AccountRegistered.class);
                startActivity(gameActivtyIntent);
            }

        });

        //New Account
        Button newInButton = (Button) findViewById(R.id.newIn);
        newInButton.setOnClickListener(new View.OnClickListener() {
            /**
             * click to this button if you are a new user
             * @param v
             */
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "ENTER YOUR INFORMATION ", Toast.LENGTH_SHORT).show();
                Intent gameActivtyIntent=new Intent(AccountMain.this, Account.class);
                startActivity(gameActivtyIntent);
            }

        });
    }
}