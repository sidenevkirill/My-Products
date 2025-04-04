package com.example.myapplication.history;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.HistoryAdapter;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private HistoryAdapter myAdapter;
    private List<String> itemList;

    public static HistoryFragment newInstance() {
        Bundle args = new Bundle();

        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        itemList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            itemList.add("Продукт " + i);
        }

        myAdapter = new HistoryAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        return root;
    }
}