package com.example.eldenringapp.Armures;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eldenringapp.R;
import com.squareup.picasso.Picasso;

public class ArmuresDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}