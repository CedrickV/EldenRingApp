package com.example.eldenringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.eldenringapp.Classe.ClasseActivity;

public class MainActivity extends AppCompatActivity {
    public Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.classe_imageView);
        Glide.with(this).load(R.raw.eldenring).into(imageView);

















        Button buttonClasse = findViewById(R.id.button_Act3);
        buttonClasse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ClasseActivity.class);
                startActivity(intent);
            }
        });
















    }
}


