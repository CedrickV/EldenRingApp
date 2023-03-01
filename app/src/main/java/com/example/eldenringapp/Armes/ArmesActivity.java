package com.example.eldenringapp.Armes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.SearchView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.eldenringapp.Armures.Armures;
import com.example.eldenringapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArmesActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    RecyclerView armeList;
    ArmesAdapter adapter;
    List<Armes> toutes_armes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.toolbar_layout);
        setContentView(R.layout.activity_armes);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        toutes_armes = new ArrayList<>();
        armeList = findViewById(R.id.armesList);
        armeList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArmesAdapter(this,toutes_armes);
        armeList.setAdapter(adapter);

        getJsonData();

        SearchView searchView = findViewById(R.id.armes_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Armes> filteredModelList = filter(toutes_armes, newText);
                adapter.setFilter(filteredModelList);
                return false;
            }

        });

    }

    private List<Armes> filter(List<Armes> models, String query) {
        query = query.toLowerCase();
        final List<Armes> filteredModelList = new ArrayList<>();
        for (Armes model : models) {
            final String textName = model.getName().toLowerCase();
            if (textName.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private void getJsonData() {
        String URL = "https://eldenring.fanapis.com/api/weapons?limit=500";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, response -> {
            //Log.d(TAG, "onResponse: " +response);
            try {
                JSONArray datas = response.getJSONArray("data");

                //Log.d(TAG, "onResponse: "+ datas);

                for (int i = 0; i < datas.length(); i++) {
                    JSONObject data = datas.getJSONObject(i);

                    Armes armes = new Armes();

                    armes.setName(data.getString("name"));
                    armes.setDescription(data.getString("description"));
                    armes.setArmeUrl(data.getString("image"));

                    JSONArray resistance = data.getJSONArray("attack");

                    String phy = resistance.getJSONObject(0).getString("amount");
                    String mag = resistance.getJSONObject(1).getString("amount");
                    String fire = resistance.getJSONObject(2).getString("amount");
                    String ligt = resistance.getJSONObject(3).getString("amount");
                    String holy = resistance.getJSONObject(4).getString("amount");
                    String crit = resistance.getJSONObject(5).getString("amount");

                    armes.setPhy("Phy : " +phy);
                    armes.setMag("Mag : " +mag);
                    armes.setFire("Fire : " +fire);
                    armes.setLigt("Ligt : "+ligt);
                    armes.setHoly("Holy : "+holy);
                    armes.setCrit("Crit : "+crit);

                    toutes_armes.add(armes);
                    adapter.notifyDataSetChanged();
                }


            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }, error -> Log.d(TAG, "onErrorResponse" + error.getMessage()));

        requestQueue.add(objectRequest);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}