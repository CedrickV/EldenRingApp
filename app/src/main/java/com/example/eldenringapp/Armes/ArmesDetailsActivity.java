package com.example.eldenringapp.Armes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eldenringapp.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ArmesDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.toolbar_layout);
        setContentView(R.layout.activity_armes_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle data = i.getExtras();
        Armes armes = (Armes) data.getSerializable("armeData");

        TextView name = findViewById(R.id.nomdArme);
        TextView desc = findViewById(R.id.armeDescription);
        ImageView imageArme = findViewById(R.id.imagedArme);

        TextView phy = findViewById(R.id.stat_arme_phy);
        TextView mag = findViewById(R.id.stat_arme_mag);
        TextView fire = findViewById(R.id.stat_arme_fire);
        TextView ligt = findViewById(R.id.stat_arme_ligt);
        TextView holy = findViewById(R.id.stat_arme_holy);
        TextView crit = findViewById(R.id.stat_arme_crit);

        phy.setText(armes.getPhy());
        mag.setText(armes.getMag());
        fire.setText(armes.getFire());
        ligt.setText(armes.getLigt());
        holy.setText(armes.getHoly());
        crit.setText(armes.getCrit());

        name.setText(armes.getName());
        desc.setText(armes.getDescription());
        Picasso.get().load(armes.getArmeUrl()).into(imageArme);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}