package com.example.musicapp_gr2.api.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.musicapp_gr2.R;
import com.example.musicapp_gr2.entity.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {

    private List<Artist> artists = new ArrayList<>();

    public ArtistAdapter() {
    }

    public void updateData(List<Artist> newArtists) {
        artists.clear();
        if (newArtists != null) {
            artists.addAll(newArtists);
        }
        notifyDataSetChanged();
    }

    public static class ArtistViewHolder extends RecyclerView.ViewHolder {
        public ImageView artistImage;
        public TextView artistName;
        public TextView artistPopularity;

        public ArtistViewHolder(View view) {
            super(view);
            artistImage = view.findViewById(R.id.artistImage);
            artistName = view.findViewById(R.id.artistName);
            artistPopularity = view.findViewById(R.id.artistPopularity);
        }
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);
        return new ArtistViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return artists.size();
    }


    @Override
    public void onBindViewHolder(ArtistViewHolder holder, int position) {
        Artist artist = artists.get(position);

        holder.artistName.setText(artist.getName());
        holder.artistPopularity.setText("Popularity: " + artist.getPopularity());

        Glide.with(holder.itemView.getContext())
                .load(artist.getImageUrl())
                .apply(RequestOptions.circleCropTransform()) // Crop hình tròn
                .into(holder.artistImage);
    }
}