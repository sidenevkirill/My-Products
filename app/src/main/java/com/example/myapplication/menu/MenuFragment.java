package com.example.myapplication.menu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.SearchAdapter;
import com.example.myapplication.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {

    public static MenuFragment newInstance() {
        Bundle args = new Bundle();

        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_menu, container, false);

     //   TextView name = root.findViewById(R.id.name);
     //   name.setText(DatabaseHelper.COLUMN_USERNAME);

        LinearLayout add = root.findViewById(R.id.help);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Упс, еще в разработке", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}