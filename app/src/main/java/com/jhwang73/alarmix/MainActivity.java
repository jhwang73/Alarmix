package com.jhwang73.alarmix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jhwang73.alarmix.fragment.dashboard.AlarmsDashboardFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavView;

    private Fragment fragmentAlarmsDashboard;
    private Fragment fragmentPlaylistsDashboard;
    private Fragment fragmentAccountsDashboard;
    private Fragment fragmentMoreMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFragments();
        initializeBottomNavigationView();
        displayHomeFragment();
    }

    private void initializeFragments() {
        fragmentAlarmsDashboard = new AlarmsDashboardFragment();
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
                        return fragmentAlarmsDashboard;
                    case R.id.nav_playlist:
                        return fragmentPlaylistsDashboard;
                    case R.id.nav_account:
                        return fragmentAccountsDashboard;
                    case R.id.nav_more_menu:
                        return fragmentMoreMenu;
                    default:
                        throw new RuntimeException("Unrecognized id found: " + itemId);
                }
            }

        });
    }

    private void displayHomeFragment() {
        displayNewFragment(fragmentAlarmsDashboard);
    }

    private void displayNewFragment(Fragment newFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit();
    }
}
