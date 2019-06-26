package com.jhwang73.alarmix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavView;

    private Fragment fragmentAlarmManager;
    private Fragment fragmentPlaylistManager;
    private Fragment fragmentAccountManager;
    private Fragment fragmentMoreMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFragments();
        initializeBottomNavigationView();
//        displayHomeFragment();
    }

    private void initializeFragments() {
    }

    private void initializeBottomNavigationView() {
        bottomNavView = findViewById(R.id.bottom_navigation);
        bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                Fragment selectedFragment = getSelectedFragmentById(itemId);
                displayNewFragment(selectedFragment);
                return true;
            }

            private Fragment getSelectedFragmentById(int itemId) {
                switch (itemId) {
                    case R.id.nav_alarm:
                        return fragmentAlarmManager;
                    case R.id.nav_playlist:
                        return fragmentPlaylistManager;
                    case R.id.nav_account:
                        return fragmentAccountManager;
                    case R.id.nav_more_menu:
                        return fragmentMoreMenu;
                    default:
                        throw new RuntimeException("Unrecognized id found: " + itemId);
                }
            }

        });
    }

    private void displayHomeFragment() {
        displayNewFragment(fragmentAlarmManager);
    }

    private void displayNewFragment(Fragment newFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }
}
