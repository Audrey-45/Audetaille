package com.example.project.view;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project.R;
import com.example.project.controller.Control;
import com.example.project.model.Acc;
import com.example.project.model.CartArticles;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class  AccountRegistered extends AppCompatActivity {

    private Control control;
    private String email;
    private String password;

    /**
     * Activity to enter email and password, and check if the user is or not already registered
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_registered);
        this.control = Control.getInstance(this);
        ArrayList<Acc> listAccount = control.getAllAccount();

        //Enter email
        EditText emailText = (EditText) findViewById(R.id.emailRegi);
        Button emailButton = (Button) findViewById(R.id.button_emailRegi);
        emailButton.setOnClickListener(new View.OnClickListener() {
            /**
             * enter mail and validate it with the button
             * @param v
             */
            public void onClick(View v) {
                email = emailText.getText().toString();
                Toast.makeText(getBaseContext(), "You email is " + email + ".", Toast.LENGTH_SHORT).show();
            }

        });

        //Enter password
        EditText passwordText = (EditText) findViewById(R.id.passRegi);
        Button passwordButton = (Button) findViewById(R.id.button_passwordRegi);
        passwordButton.setOnClickListener(new View.OnClickListener() {
            /**
             * enter password and validate it with the button
             * @param v
             */
            public void onClick(View v) {
                password = passwordText.getText().toString();
                Toast.makeText(getBaseContext(), "You password is " + password + ".", Toast.LENGTH_SHORT).show();
            }

        });

        //Button to check is all informations are present
        //Button check in the database if the account is registered or not
        Button checkButton = (Button) findViewById(R.id.checkRegi);
        checkButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button to check is the 2 parameters are set
             * Check in database if information corresponding or not
             * @param v
             */
            public void onClick(View v) {
                boolean wrong = false;

                for(int i=0; i<listAccount.size(); i++)
                {
                    if ((listAccount.get(i).getEmail()).equals(email) && (listAccount.get(i).getPassword()).equals(password))
                    {
                        wrong=true;
                        Toast.makeText(getBaseContext(), "WELCOME BACK " + (listAccount.get(i).getFirstName()) + " "
                            + (listAccount.get(i).getLastName()), Toast.LENGTH_LONG).show();
                        Intent gameActivtyIntent=new Intent(AccountRegistered.this, MainActivity.class);
                        startActivity(gameActivtyIntent);
                    }
                }

                if(!wrong)
                {
                   Toast.makeText(getBaseContext(), "WRONG", Toast.LENGTH_LONG).show();
                }


            }

        });

        Button createButton = (Button) findViewById(R.id.creation);
        createButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button to come back to Account Activty, for new User
             * @param v
             */
            public void onClick(View v) {
                Intent gameActivtyIntent=new Intent(AccountRegistered.this, Account.class);
                startActivity(gameActivtyIntent);
            }

        });
    }
}