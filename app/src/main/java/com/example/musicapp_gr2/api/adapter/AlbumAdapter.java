package com.example.musicapp_gr2.api.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.musicapp_gr2.R;
import com.example.musicapp_gr2.entity.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> albums = new ArrayList<>();

    // Constructor với danh sách album (có thể null ban đầu)
    public AlbumAdapter() {
    }

    // Phương thức cập nhật dữ liệu
    public void updateData(List<Album> newAlbums) {
        albums.clear();
        if (newAlbums != null) {
            albums.addAll(newAlbums);
        }
        notifyDataSetChanged();
    }

    // ViewHolder class
    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        public TextView albumName;
        public TextView artistName;
        public TextView releaseDate;
        public ImageView albumImage;

        public AlbumViewHolder(View view) {
            super(view);
            albumName = view.findViewById(R.id.albumName);
            artistName = view.findViewById(R.id.artistName);
            releaseDate = view.findViewById(R.id.releaseDate);
            albumImage = view.findViewById(R.id.albumImage);
        }
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_album, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        Album album = albums.get(position);

        holder.albumName.setText(album.getName());
        holder.artistName.setText(album.getArtist());
        holder.releaseDate.setText("Release: " + album.getReleaseDate());

        // Load image with Glide
        Glide.with(holder.itemView.getContext())
                .load(album.getImageUrl())

                .into(holder.albumImage);

        // Thay thế click listener bằng hành động hiển thị ID
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String albumId = album.getId(); // Giả sử Album có phương thức getId() (cần thêm)
                Log.d("AlbumClick", "Album ID: " + albumId); // Hiển thị ID trong Logcat
                // Hoặc hiển thị trên giao diện (xem bước 2 dưới đây)
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }
}