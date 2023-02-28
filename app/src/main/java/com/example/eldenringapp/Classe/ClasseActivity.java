package com.example.eldenringapp.Classe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.eldenringapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ClasseActivity extends AppCompatActivity {

    public static final String TAG = "";
    RecyclerView ClasseList;
    ClasseAdapter adapter;
    List<Classe> all_classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classe);
        all_classes = new ArrayList<>();

        ClasseList = findViewById(R.id.class_recycler_view);
        ClasseList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClasseAdapter(all_classes, this);
        ClasseList.setAdapter(adapter);

        getJsonData();
    }

    private void getJsonData() {
        String URL = "https://eldenring.fanapis.com/api/classes?limit=100";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray Data = response.getJSONArray("data");
                    for (int i = 0; i < Data.length(); i++){

                        //Récupération des données générales
                        JSONObject donnee = Data.getJSONObject(i);
                        Classe c = new Classe(donnee.getString("name"),
                                donnee.getString("image"),
                                donnee.getString("description"));

                        //Récupération des données stats
                        JSONObject datastats = donnee.getJSONObject("stats");
//                        Log.d(TAG, "onResponse : "+datastats);
                        c.setStats(datastats.getString("level"),datastats.getString("vigor"),datastats.getString("mind"),
                                datastats.getString("endurance"),datastats.getString("strength"),datastats.getString("dexterity"),
                                datastats.getString("intelligence"),datastats.getString("faith"),datastats.getString("arcane"));

                        all_classes.add(c);
                        adapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse : "+error.getMessage());

            }
        });

        requestQueue.add(objectRequest);


    }
}