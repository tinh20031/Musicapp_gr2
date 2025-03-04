package com.example.musicapp_gr2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MusicLibraryActivity extends AppCompatActivity {

    private RecyclerView rvSongs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_main); // Đảm bảo đúng layout chứa RecyclerView

        // Ánh xạ RecyclerView từ layout
        rvSongs = findViewById(R.id.recycler_view); // Đảm bảo ID đúng với XML

        if (rvSongs != null) {
            rvSongs.setLayoutManager(new LinearLayoutManager(this));
        } else {
            // Log lỗi nếu RecyclerView bị null
            System.err.println("RecyclerView rvSongs is null! Check the layout XML.");
        }
    }
}
