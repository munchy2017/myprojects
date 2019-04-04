package com.example.prosp.botszone.users;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.prosp.botszone.R;
import com.example.prosp.botszone.categories.all.allstaff;

public class Splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_DURATION = 5000;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(Splash.this,allstaff.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_DURATION);
    }}