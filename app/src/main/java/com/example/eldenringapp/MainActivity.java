package com.example.eldenringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.eldenringapp.Armes.ArmesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.class_imageView);
        Glide.with(this).load(R.raw.eldenring).into(imageView);

        Button buttonArmes = findViewById(R.id.button_Armes);
        buttonArmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArmesActivity.class);
                startActivity(intent);
            }
        });

    }
}


