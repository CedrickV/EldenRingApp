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