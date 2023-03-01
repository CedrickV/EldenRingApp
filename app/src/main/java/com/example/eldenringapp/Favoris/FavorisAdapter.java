package com.example.eldenringapp.Favoris;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eldenringapp.Classe.ClasseAdapter;
import com.example.eldenringapp.R;

import java.util.List;

public class FavorisAdapter extends RecyclerView.Adapter<FavorisAdapter.ViewHolder> {
    private List<Object> allFavoris;
    private Context context;


    @NonNull
    @Override
    public FavorisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.classe_view,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavorisAdapter.ViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull FavorisAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return allFavoris.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        View vv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            vv = itemView;
        }
    }

}
