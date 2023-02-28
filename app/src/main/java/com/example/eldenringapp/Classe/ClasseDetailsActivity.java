package com.example.eldenringapp.Classe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eldenringapp.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class ClasseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe_details);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle data = i.getExtras();
        Classe c = (Classe) data.getSerializable("ClassData");


        TextView title = findViewById(R.id.classe_details_name);
        TextView description = findViewById(R.id.classe_details_description);
        ImageView image = findViewById(R.id.classe_details_imageview);

        title.setText(c.getName());
        description.setText(c.getDescription());
        Picasso.get().load(c.getImageURL()).into(image);

        //TextviewStats
        TextView lvl = findViewById(R.id.stat_classe_lvl);
        TextView vigor = findViewById(R.id.stat_classe_vigor);
        TextView mind = findViewById(R.id.stat_classe_mind);
        TextView endurance = findViewById(R.id.stat_classe_endurance);
        TextView strength = findViewById(R.id.stat_classe_strength);
        TextView dex = findViewById(R.id.stat_classe_dexterity);
        TextView intel = findViewById(R.id.stat_classe_int);
        TextView faith = findViewById(R.id.stat_classe_faith);
        TextView arcane = findViewById(R.id.stat_classe_arcane);


        //Putting the data in those textviews
        lvl.setText(c.getLevel());
        vigor.setText(c.getVigor());
        mind.setText(c.getMind());
        endurance.setText(c.getEnd());
        strength.setText(c.getStr());
        dex.setText(c.getDex());
        intel.setText(c.getIntelligence());
        faith.setText(c.getFaith());
        arcane.setText(c.getArc());








    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}