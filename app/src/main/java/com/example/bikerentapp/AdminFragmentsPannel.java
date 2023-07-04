package com.example.bikerentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdminFragmentsPannel extends Fragment {
private TextView ItemInserted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_admin_fragments_pannel, container, false);
        RecyclerView recyclerView;
        List<AdminViewModel>list;
        recyclerView=view.findViewById(R.id.recyeclerAdmin);
        recyclerView.setHasFixedSize(true);
        list=new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        list.add(new AdminViewModel(R.drawable.image46,"New Bikes"));
        list.add(new AdminViewModel(R.drawable.image47,"Item Insert"));
        list.add(new AdminViewModel(R.drawable.image49,"Booking"));
        list.add(new AdminViewModel(R.drawable.iamge50,"Finical"));
        AdminAdapter adminAdapter=new AdminAdapter(list);
        recyclerView.setAdapter(adminAdapter);
        return view;
    }
}