package com.example.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private ListAdapter myAdapter;
    private List<String> itemList;

    public static MainFragment newInstance(int position) {
        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Создание списка элементов
        itemList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            itemList.add("Продукт " + i);
        }

        // Инициализация адаптера
        myAdapter = new ListAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        return root;
    }
}