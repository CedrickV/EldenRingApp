package com.example.eldenringapp.Favoris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eldenringapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FavorisActivity extends AppCompatActivity {

    ListView listFav ;
    List<Favoris> objetsFav;

    FavorisAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.toolbar_layout);
        setContentView(R.layout.activity_favoris);

        //listview
        List<Favoris> favorisList = new ArrayList<>();
        objetsFav = new ArrayList<>();

        //get list view
        listFav =  findViewById(R.id.listview_favoris);
        listFav.setAdapter(adapter = new FavorisAdapter(this, objetsFav));











    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}