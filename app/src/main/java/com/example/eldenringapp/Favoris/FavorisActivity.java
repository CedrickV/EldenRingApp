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
    static List<Favoris> objetsFav;

    static FavorisAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.toolbar_layout);
        setContentView(R.layout.activity_favoris);

        objetsFav = new ArrayList<>();

        //get list view
        listFav =  findViewById(R.id.listview_favoris);
        listFav.setAdapter(adapter = new FavorisAdapter(this, objetsFav));


    }

    public static void addFavoris(String name, String desc, String url){
        Favoris newFav = new Favoris(name,desc,url);
        if (!objetsFav.contains(newFav))
        {
            objetsFav.add(newFav);
            adapter.notifyDataSetChanged();
        }
    }
    public static void removeFavoris (Favoris fav){
        if (objetsFav.contains(fav)){
            objetsFav.remove(fav);
            System.out.println("Favoris successly removed");
        }
        System.out.println("Favoris couldnt be removed because not in list");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}