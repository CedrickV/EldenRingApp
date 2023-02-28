package com.example.eldenringapp.Armures;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eldenringapp.Armes.Armes;
import com.example.eldenringapp.Armes.ArmesDetailsActivity;
import com.example.eldenringapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ArmuresAdapter extends RecyclerView.Adapter<ArmuresAdapter.ViewHolder> {
    private List<Armures> toutesArmures;
    private Context context;

    public ArmuresAdapter(Context ctx, List<Armures> armures) {
        this.toutesArmures = armures;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.armures_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(toutesArmures.get(position).getName());
        Picasso.get().load(toutesArmures.get(position).getArmuresUrl()).into(holder.armureImage);

        holder.vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                b.putSerializable("armureData",toutesArmures.get(position));
                Intent intent = new Intent(context, ArmuresDetailsActivity.class);
                intent.putExtras(b);
                view.getContext().startActivity(intent);
            }
        });
    }
    public void setFilter(List<Armures> armures) {
        toutesArmures = new ArrayList<>();
        toutesArmures.addAll(armures);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return toutesArmures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView armureImage;
        TextView name;
        View vv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            armureImage = itemView.findViewById(R.id.imageArmure);
            name = itemView.findViewById(R.id.nomArmure);
            vv = itemView;
        }
    }
}
