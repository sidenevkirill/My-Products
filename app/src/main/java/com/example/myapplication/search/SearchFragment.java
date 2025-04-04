package com.example.myapplication.search;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ListAdapter;
import com.example.myapplication.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private SearchAdapter myAdapter;
    private List<String> itemList;

    public static SearchFragment newInstance() {
        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Создание списка элементов
        itemList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            itemList.add("Продукт " + i);
        }

        // Инициализация адаптера
        myAdapter = new SearchAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        return root;
    }
}