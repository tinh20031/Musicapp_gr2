package com.example.musicapp_gr2.api.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp_gr2.R;
import com.example.musicapp_gr2.entity.Show;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewHolder> {

    private List<Show> shows = new ArrayList<>();

    public ShowAdapter() {
    }

    public void updateData(List<Show> newShows) {
        shows.clear();
        if (newShows != null) {
            shows.addAll(newShows);
        }
        notifyDataSetChanged();
        Log.d("SHOW_ADAPTER", "Updated with " + shows.size() + " items");
    }

    public static class ShowViewHolder extends RecyclerView.ViewHolder {
        public ImageView showImage;
        public TextView showName;
        public TextView showPublisher;

        public ShowViewHolder(View view) {
            super(view);
            showImage = view.findViewById(R.id.showImage);
            showName = view.findViewById(R.id.showName);
            showPublisher = view.findViewById(R.id.showPublisher);
        }
    }

    @Override
    public ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_show, parent, false);
        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowViewHolder holder, int position) {
        Show show = shows.get(position);

        holder.showName.setText(show.getName());
        holder.showPublisher.setText(show.getPublisher());
        String imageUrl = show.getImageUrl();
        Log.d("IMAGE_DEBUG", "Image URL for " + show.getName() + ": " + imageUrl);
        if (imageUrl == null || imageUrl.isEmpty()) {
            Log.e("IMAGE_DEBUG", "Image URL is null or empty for " + show.getName());
        } else {
            Log.d("IMAGE_DEBUG", "Attempting to load: " + imageUrl);
            Picasso.get()
                    .load(imageUrl)
                    .resize(150, 150) // Kích thước vuông
                    .centerCrop()
                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .noPlaceholder()
                    .error(R.drawable.error_image) // Hiển thị khi lỗi
                    .into(holder.showImage, new Callback() {
                        @Override
                        public void onSuccess() {
                            Log.d("PICASSO_SUCCESS", "Image loaded for " + imageUrl);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e("PICASSO_ERROR", "Image load failed for " + imageUrl + ": " + e.getMessage());
                        }
                    });
        }
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }
}