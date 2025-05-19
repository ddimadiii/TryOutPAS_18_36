package com.example.tryoutpas_18_36.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tryoutpas_18_36.R;
import com.example.tryoutpas_18_36.ui.fragment.EnglishFragment;
import com.example.tryoutpas_18_36.ui.fragment.FragmentHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        bottom_navigation = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, new FragmentHome())
                .commit();

        bottom_navigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                fragment = new FragmentHome();
            } else if (itemId == R.id.nav_english) {
                fragment = new EnglishFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_layout, fragment)
                        .commit();
                return true;
            }
            return false;
        });
    }
}
