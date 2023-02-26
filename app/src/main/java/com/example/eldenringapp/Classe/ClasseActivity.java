package com.example.eldenringapp.Classe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.eldenringapp.R;

public class ClasseActivity extends AppCompatActivity {

    RecyclerView ClasseList;
    ClasseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe);

        ClasseList = findViewById(R.id.class_recycler_view);
        adapter = new ClasseAdapter();

        ClasseList.setLayoutManager(new LinearLayoutManager(this));
        ClasseList.setAdapter(adapter);

    }
}