package com.example.myapplication;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ListAdapter;
import com.example.myapplication.favorite.FavoritePagerFragment;
import com.example.myapplication.history.HistoryFragment;
import com.example.myapplication.history.HistoryPagerFragment;
import com.example.myapplication.home.HomeFragment;
import com.example.myapplication.menu.MenuFragment;
import com.example.myapplication.search.SearchFragment;
import com.example.myapplication.search.SearchPagerFragment;
import com.example.myapplication.settings.SettingsActivity;
import com.example.myapplication.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;


public class MainAcivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListAdapter myAdapter;
    private List<String> itemList;
    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = new MainFragment();

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.item_home:
                            changeFragment(new HomeFragment());
                            break;
                        case R.id.item_friends:
                            changeFragment(new SearchPagerFragment());
                            break;
                        case R.id.item_local_music:
                            changeFragment(new HistoryPagerFragment());
                            break;
                        case R.id.item_search:
                            changeFragment(new MenuFragment());
                            break;
                    }
                    return true;
                });

        changeFragment(new HomeFragment());
        //changeFragment(AudiosFragment.newInstance());
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

    }

    public void onHome(View v) {
        HomeFragment nextFrag = new HomeFragment();
        MainAcivity.this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    public void onSearch(View v) {
        HomeFragment nextFrag = new HomeFragment();
        MainAcivity.this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    public void onHistory(View v) {
        HomeFragment nextFrag = new HomeFragment();
        MainAcivity.this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    public void onFavorite(View v) {
        FavoritePagerFragment nextFrag = new FavoritePagerFragment();
        MainAcivity.this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, nextFrag, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }

    public void onLogin(View v) {
        Intent intent = new Intent(MainAcivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void onSettings(View v) {
        Intent intent = new Intent(MainAcivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_home:
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnExit (View view) {
        // Завершить работу данного окна
        this.finish();
    }


}