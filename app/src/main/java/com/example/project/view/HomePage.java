package com.example.project.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.project.R;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class HomePage extends AppCompatActivity {

    //proprieties
    private final int TIME_DELAY = 3000;
    private ProgressBar progressBar;
    private Button button;

    /**
     * Creation activity home page when we launch the programm
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button = (Button) findViewById(R.id.button_home_page);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);



        button.setOnClickListener(new View.OnClickListener() {
            /**
             * button to enter in the shop, with the activation of a progress bar to load information
             * @param v
             */
                      @Override
            public void onClick(View v) {
                progressBar.getIndeterminateDrawable()
                        .setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.blue), PorterDuff.Mode.SRC_IN);
                          new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, TIME_DELAY);
            }
        });




    }

}
