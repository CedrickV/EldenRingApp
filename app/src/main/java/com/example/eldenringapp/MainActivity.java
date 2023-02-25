package com.example.eldenringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(R.raw.eldenring).into(imageView);



    }
}


