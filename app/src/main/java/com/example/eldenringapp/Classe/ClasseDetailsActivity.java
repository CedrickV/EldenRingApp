package com.example.eldenringapp.Classe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eldenringapp.R;
import com.squareup.picasso.Picasso;

public class ClasseDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle data = i.getExtras();
        Classe c = (Classe) data.getSerializable("ClassData");


        TextView title = findViewById(R.id.classe_details_name);
        TextView description = findViewById(R.id.classe_details_description);
        ImageView image = findViewById(R.id.classe_details_imageview);

        title.setText(c.getName());
        description.setText(c.getDescription());
        Picasso.get().load(c.getImageURL()).into(image);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);




    }
}