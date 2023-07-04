package com.example.bikerentapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class RentBikeFragments extends Fragment {
    FirebaseStorage mStore;
    DBFile obj;
    List<RentBikeModel> rentBikeModels;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_rent_bike_fragments, container, false);
        RecyclerView recyclerView;
        recyclerView=view.findViewById(R.id.RecyclerRuntBikes);
        recyclerView.setHasFixedSize(true);
        mStore=FirebaseStorage.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rentBikeModels=new ArrayList<>();
        RentAdapter adapter=new RentAdapter(rentBikeModels);
        recyclerView.setAdapter(adapter);

        obj=new DBFile();
        FirebaseDatabase database= FirebaseDatabase.getInstance();

        database.getReference("RentBike").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot FatchData:snapshot.getChildren()) {
                    RentBikeModel model = FatchData.getValue(RentBikeModel.class);
                    String name=FatchData.child("renterName").getValue(String.class);
                    String price =FatchData.child("rentPrice").getValue(String.class);
                    String ima =FatchData.child("image").getValue(String.class);
                    rentBikeModels.add(new RentBikeModel(name,ima,price));

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return  view;
    }
}