package com.example.eldenringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.eldenringapp.Armures.Armures;
import com.example.eldenringapp.Armures.ArmuresActivity;
import com.example.eldenringapp.Classe.ClasseActivity;
import com.example.eldenringapp.Armes.ArmesActivity;
import com.example.eldenringapp.Recherche.RechercheActivity;

public class MainActivity extends AppCompatActivity {
    public Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.classe_imageView);
        Glide.with(this).load(R.raw.eldenring).into(imageView);

        Button buttonArmes = findViewById(R.id.button_Armes);
        buttonArmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArmesActivity.class);
                startActivity(intent);
            }
        });

        Button buttonArmures = findViewById(R.id.button_Armures);
        buttonArmures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ArmuresActivity.class);
                startActivity(intent);
            }
        });


        Button buttonClasse = findViewById(R.id.button_Act3);
        buttonClasse.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ClasseActivity.class);
            startActivity(intent);
        });

        Button buttonRecherche = findViewById(R.id.button_Act4);
        buttonRecherche.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RechercheActivity.class);
            startActivity(intent);
        });
















    }
}


