package com.example.myapplication.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.MainFragment;
import com.example.myapplication.R;
import com.example.myapplication.adapter.ViewPagerAdapter;
import com.example.myapplication.favorite.FavoriteFragment;
import com.google.android.material.tabs.TabLayout;

public class HistoryPagerFragment extends Fragment {
    private ViewPagerAdapter adapter;

    public static HistoryPagerFragment newInstance() {
        Bundle args = new Bundle();

        HistoryPagerFragment fragment = new HistoryPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_history_pager, container, false);

        ViewPager viewPager = root.findViewById(R.id.viewpager);
        TabLayout tabLayout = root.findViewById(R.id.tablayout);

        // attach tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        // add your fragments
        adapter.addFrag(new HistoryFragment(), "Продукты");
      //  adapter.addFrag(new FavoriteFragment(), "Избранное");

        // set adapter on viewpager
        viewPager.setAdapter(adapter);

        return root;

    }
}