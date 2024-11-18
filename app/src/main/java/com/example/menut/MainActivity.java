package com.example.menut;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        setFragment(new SecondFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first_item) {
                    setFragment(new FirstFragment());
                    return true;
                } else if (item.getItemId() == R.id.second_item) {
                    setFragment(new SecondFragment());
                    return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_lay, fragment, null).commit();
    }
}