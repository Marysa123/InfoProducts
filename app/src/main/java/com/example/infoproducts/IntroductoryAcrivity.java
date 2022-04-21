package com.example.infoproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryAcrivity extends AppCompatActivity {

    ImageView logo,splash_images,text_bot;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory_acrivity);

        splash_images = findViewById(R.id.img_bg);

        splash_images.animate().translationY(-1800).setDuration(1000).setStartDelay(2000);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroductoryAcrivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3200);//Ст


    }
}