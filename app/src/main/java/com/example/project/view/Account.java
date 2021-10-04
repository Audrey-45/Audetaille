package com.example.project.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import com.example.project.R;
import com.example.project.controller.Control;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Account extends AppCompatActivity {

    //proprieties
    private Control control;
    private String firstname;
    private String lastname;
    private String password;
    private String email;

    /**
     * Enter first name, last name, email and password and add them to the database
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //database update
        this.control = Control.getInstance(this);

        //edit for password
        final EditText passwordField = (EditText) findViewById(R.id.passRegi);

        Button passwordButton = (Button) findViewById(R.id.button_passwordRegi);
        passwordButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button click to valid password
             * @param v
             */
            public void onClick(View v) {
                String text = passwordField.getText().toString();
                boolean valid = true;
                boolean hasNumbers = false;
                boolean hasLetters = false;

                //check if the password have number and letter to be valid
                for (int i=0; i<text.length(); i++) {
                    if (Character.isDigit(text.charAt(i))){
                        hasNumbers = true;
                    }
                    else if (Character.isLetter(text.charAt(i))) {
                        hasLetters = true;
                    } else {
                        valid = false;
                        break;
                    }
                }
                if (valid && hasLetters && hasNumbers) {
                    Toast.makeText(getBaseContext(), "Password " + text + " is valid.", Toast.LENGTH_SHORT).show();
                    password = text;

                } else {
                    Toast.makeText(getBaseContext(), "Password " + text + " is not valid", Toast.LENGTH_SHORT).show();
                }
            }

        });

        //edit for first name
        EditText firstNameText = (EditText) findViewById(R.id.editText);
        //limit the name at 20 letters
        firstNameText.setFilters(new InputFilter[] {
                new InputFilter.LengthFilter(20),
                new InputFilter.AllCaps()
        });


        Button fnButton = (Button) findViewById(R.id.button_fn);
        fnButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button to validate first name
             * @param v
             */
            public void onClick(View v) {
                String text = firstNameText.getText().toString();
                Toast.makeText(getBaseContext(), "First Name is " + text + ".", Toast.LENGTH_SHORT).show();
                firstname=text;

            }

        });


        //edit for Last name
        EditText lastNameText = (EditText) findViewById(R.id.editText1);
        //limit the name at 20 letters
        lastNameText.setFilters(new InputFilter[] {
                new InputFilter.LengthFilter(20),
                new InputFilter.AllCaps()
        });


        Button lnButton = (Button) findViewById(R.id.button_ln);
        lnButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button for validate last name
             * @param v
             */
            public void onClick(View v) {
                String text = lastNameText.getText().toString();
                Toast.makeText(getBaseContext(), "Last Name is " + text + ".", Toast.LENGTH_SHORT).show();
                lastname=text;

            }

        });

        //edit for email
        EditText emailText = (EditText) findViewById(R.id.emailRegi);

        Button emailButton = (Button) findViewById(R.id.button_emailRegi);
        emailButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button for validate email
             * @param v
             */
            public void onClick(View v) {
                String text = emailText.getText().toString();
                Toast.makeText(getBaseContext(), "Email is " + text + ".", Toast.LENGTH_SHORT).show();
                email=text;

            }

            });



        //button to get all the information in Wamp
        Button chkButton = (Button) findViewById(R.id.checkRegi);
        chkButton.setOnClickListener(new View.OnClickListener() {
            /**
             * button to check if the 4 parameters are set and validate with the 4 buttons
             * If it's ok 4 parameters are add to the account in database
             * @param v
             */
            public void onClick(View v) {

                if(firstname!=null&&lastname!=null&&password!=null&&email!=null)
                {
                    control.AddAcc(firstname, lastname, password, email);
                    Toast.makeText(getBaseContext(), "Welcome to AUDETAILLE", Toast.LENGTH_LONG).show();
                    //Open mainactivity
                    Intent gameActivtyIntent=new Intent(Account.this, MainActivity.class);
                    startActivity(gameActivtyIntent);
                }
                else
                {
                    Toast.makeText(getBaseContext(), "INFORMATION IS MISSING", Toast.LENGTH_LONG).show();
                }

            }

        });






    }
}
