package com.example.eldenringapp.Armures;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.eldenringapp.Armes.Armes;
import com.example.eldenringapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArmuresActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    RecyclerView armuresList;
    List<Armures> toutes_armures;

    ArmuresAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armures);

        toutes_armures = new ArrayList<>();
        armuresList = findViewById(R.id.armuresList);
        armuresList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArmuresAdapter(this, toutes_armures);
        armuresList.setAdapter(adapter);

        getJsonData();

        SearchView searchView = findViewById(R.id.armures_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Armures> filteredModelList = filter(toutes_armures, newText);
                adapter.setFilter(filteredModelList);
                return false;
            }

        });

    }
    private List<Armures> filter(List<Armures> models, String query) {
        query = query.toLowerCase();
        final List<Armures> filteredModelList = new ArrayList<>();
        for (Armures model : models) {
            final String textName = model.getName().toLowerCase();
            if (textName.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;

    }
    private void getJsonData() {
        String URL = "https://eldenring.fanapis.com/api/armors?limit=500";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray datas = response.getJSONArray("data");

                    //Log.d(TAG, "onResponse: "+ datas);

                    for (int i = 0; i < datas.length(); i++) {
                        JSONObject data = datas.getJSONObject(i);

                        Armures armures = new Armures();

                        armures.setName(data.getString("name"));
                        armures.setDescription(data.getString("description"));
                        armures.setArmuresUrl(data.getString("image"));

                        toutes_armures.add(armures);
                        adapter.notifyDataSetChanged();
                    }


                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse" + error.getMessage());
            }
        });
        requestQueue.add(objectRequest);
    }
}