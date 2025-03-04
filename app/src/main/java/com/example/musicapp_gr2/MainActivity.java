package com.example.musicapp_gr2;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.musicapp_gr2.Fragment.HomeFragment;
import com.example.musicapp_gr2.Fragment.ExploreFragment;
import com.example.musicapp_gr2.Fragment.LibraryFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private ExploreFragment exploreFragment;
    private LibraryFragment libraryFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        // Khởi tạo FragmentManager
        fragmentManager = getSupportFragmentManager();

        // Khởi tạo các fragment
        homeFragment = new HomeFragment();
        exploreFragment = new ExploreFragment();
        libraryFragment = new LibraryFragment();

        // Khởi tạo BottomNavigationView
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                showFragment(homeFragment);
            } else if (id == R.id.nav_explore) {
                showFragment(exploreFragment);
            } else if (id == R.id.nav_library) {
                showFragment(libraryFragment);
            } else {
                Log.w("Navigation", "Unknown item selected");
            }
            return true;
        });

        // Đặt fragment mặc định khi khởi động
        if (savedInstanceState == null) {
            showFragment(homeFragment);
            bottomNav.setSelectedItemId(R.id.nav_home);
        }
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}
