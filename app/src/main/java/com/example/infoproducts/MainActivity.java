package com.example.infoproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = findViewById(R.id.lottie_mainage);
        lottieAnimationView.animate().setDuration(1000).setStartDelay(4000);

        findViewById(R.id.button_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ArrayInfo.class);
                startActivity(intent);

                dbHandler = new DBHandler(MainActivity.this);
                boolean insert = dbHandler.insertIntoData(1,"Колбаса","шт","ООО Мангал","1004","67.00","67","4489", "Прибытие","05.05.2022");
                if (insert == true){
                    Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                }
                else {
                   Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}