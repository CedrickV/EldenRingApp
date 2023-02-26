package com.example.eldenringapp.Classe;

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

import com.bumptech.glide.Glide;
import com.example.eldenringapp.R;

import java.util.List;

public class ClasseAdapter extends RecyclerView.Adapter<ClasseAdapter.ViewHolder>{
    private List<Classe> allClasses;
    private Context context;

    public ClasseAdapter(List<Classe> allClasses, Context context) {
        this.allClasses = allClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ClasseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_classe_view,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ClasseAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(allClasses.get(position).getName());
        holder.classeDescription.setText(allClasses.get(position).getDescription());
        Glide.with(holder.vv).load(allClasses.get(position).getImageURL()).into(holder.classeImage);

        holder.vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ClasseDetailsActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("ClassData", allClasses.get(position));
                intent.putExtras(b);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allClasses.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView classeImage;
        TextView classeDescription;
        TextView  title;
        View vv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            classeImage = itemView.findViewById(R.id.classe_imageView);
            title = itemView.findViewById(R.id.classe_name_title);
            classeDescription = itemView.findViewById(R.id.classe_description);
            vv = itemView;
        }
    }
}

