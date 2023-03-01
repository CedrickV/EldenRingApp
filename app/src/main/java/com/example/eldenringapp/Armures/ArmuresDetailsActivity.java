package com.example.eldenringapp.Armures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eldenringapp.Favoris.Favoris;
import com.example.eldenringapp.Favoris.FavorisActivity;
import com.example.eldenringapp.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ArmuresDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.toolbar_layout);
        setContentView(R.layout.activity_armures_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle data = i.getExtras();
        Armures armures = (Armures) data.getSerializable("armureData");

        TextView name = findViewById(R.id.nomdArmure);
        TextView desc = findViewById(R.id.armureDescription);
        ImageView imageArme = findViewById(R.id.imagedArmure);

        TextView immunity = findViewById(R.id.stat_armure_immunity);
        TextView focus = findViewById(R.id.stat_armure_focus);
        TextView poise = findViewById(R.id.stat_armure_poise);
        TextView robust = findViewById(R.id.stat_armure_robust);
        TextView vitality = findViewById(R.id.stat_armure_vitality);
        TextView weight = findViewById(R.id.stat_armure_weight);

        weight.setText(armures.getWeight());
        vitality.setText(armures.getVitality());
        robust.setText(armures.getRobust());
        poise.setText(armures.getPoise());
        focus.setText(armures.getFocus());
        immunity.setText(armures.getImmunity());

        name.setText(armures.getName());
        desc.setText(armures.getDescription());
        Picasso.get().load(armures.getArmuresUrl()).into(imageArme);




        Button checkboxfav = findViewById(R.id.checkBox_favoris_armures);
        checkboxfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(((CompoundButton) view).isChecked()){
                    FavorisActivity.addFavoris(armures.getName(),armures.getDescription(),armures.getArmuresUrl());
                } else {
                    Favoris fav = new Favoris(armures.getName(),armures.getDescription(),armures.getArmuresUrl());
                    FavorisActivity.removeFavoris(fav);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}