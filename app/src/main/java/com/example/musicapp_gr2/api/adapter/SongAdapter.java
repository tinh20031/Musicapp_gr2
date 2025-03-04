package com.example.musicapp_gr2.api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.musicapp_gr2.R;
import com.bumptech.glide.Glide;
import com.example.musicapp_gr2.entity.Song;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private List<Song> songs;
    private Context context;

    public SongAdapter(Context context, List<Song> songs) {
        this.context = context;
        this.songs = songs;
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView songName, artistName;
        ImageView songImage;

        public SongViewHolder(View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.songName);
            artistName = itemView.findViewById(R.id.artistName);
            songImage = itemView.findViewById(R.id.songImage);
        }
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.songName.setText(song.getName());
        holder.artistName.setText(song.getArtist());
        Glide.with(context).load(song.getImageUrl()).into(holder.songImage);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }
}
