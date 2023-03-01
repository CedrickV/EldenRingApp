package com.example.eldenringapp.Favoris;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eldenringapp.R;

import java.util.List;

public class FavorisAdapter extends BaseAdapter {

    private Context context;
    private List<Object> objetsFav;
    private List<Favoris> listFav;
    private LayoutInflater inflater;

    public FavorisAdapter(Context context, List<Favoris> listFav) {
        this.context = context;
        this.listFav = listFav;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return listFav.size();
    }

    @Override
    public Favoris getItem(int position) {
        return listFav.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.classe_view,null);

        Favoris currentFav = getItem(i);
        String name = currentFav.getName();;
        String description = currentFav.getDescription();
        String url = currentFav.getImageURL();


        TextView nameView = view.findViewById(R.id.favoris_name_title);
        TextView descView = view.findViewById(R.id.favoris_description);
        ImageView imageView = view.findViewById(R.id.favoris_imageView);

        nameView.setText(name);
        descView.setText(description);
        imageView.setImageURI(Uri.parse(url));

        return view;
    }
}
