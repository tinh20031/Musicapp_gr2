package com.example.explorepage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Arrays;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        RecyclerView rvTopGenres = findViewById(R.id.rvTopGenres);
        RecyclerView rvBrowseAll = findViewById(R.id.rvBrowseAll);

        List<String> topGenres = Arrays.asList("Kpop", "Indie", "R&B", "Pop");
        List<String> browseAll = Arrays.asList("Made for You", "RELEASED", "Music Charts", "Podcasts");

        rvTopGenres.setLayoutManager(new GridLayoutManager(this, 2));
        rvBrowseAll.setLayoutManager(new GridLayoutManager(this, 2));

        rvTopGenres.setAdapter(new GenreAdapter(topGenres));
        rvBrowseAll.setAdapter(new GenreAdapter(browseAll));

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.setSelectedItemId(R.id.bottomNavigation);
    }
}

