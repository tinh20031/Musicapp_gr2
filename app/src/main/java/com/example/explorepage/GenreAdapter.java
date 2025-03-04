package com.example.explorepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {
    private final List<String> genres;

    public GenreAdapter(List<String> genres) {
        this.genres = genres;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_genre, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvGenre.setText(genres.get(position));
    }

    @Override
    public int getItemCount() {
        return genres.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvGenre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGenre = itemView.findViewById(R.id.tvGenre);
        }
    }
}
