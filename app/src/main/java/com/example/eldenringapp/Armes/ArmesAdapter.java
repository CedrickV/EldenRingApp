package com.example.eldenringapp.Armes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eldenringapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ArmesAdapter extends RecyclerView.Adapter<ArmesAdapter.ViewHolder> {
    private List<Armes> toutesArmes;
    private Context context;

    public ArmesAdapter(Context ctx, List<Armes> armes) {
        this.toutesArmes = armes;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.armes_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nom.setText(toutesArmes.get(position).getName());
        Picasso.get().load(toutesArmes.get(position).getArmeUrl()).into(holder.armesImage);
    }

    @Override
    public int getItemCount() {
        return toutesArmes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView armesImage;
        TextView nom;
        View vv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            armesImage = itemView.findViewById(R.id.imageArme);
            nom = itemView.findViewById(R.id.nomArme);
            vv = itemView;
        }
    }
}
