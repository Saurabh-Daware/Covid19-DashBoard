package com.example.covid19dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2000)
                .withBackgroundColor(Color.WHITE)
                .withFooterText("Welcome")
                .withAfterLogoText("Covid19 Tracker")
                .withLogo(R.mipmap.ic_launcher);


        config.getAfterLogoTextView().setTextColor(Color.rgb(0,0,0));
        config.getAfterLogoTextView().setTextSize((float) 20d);

        View easySplashScreen = config.create();
        setContentView(easySplashScreen);





    }

}