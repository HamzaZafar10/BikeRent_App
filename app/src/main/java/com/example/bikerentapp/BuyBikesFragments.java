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
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class BuyBikesFragments extends Fragment {
    FirebaseStorage mStore;
    DBFile obj;
    List<SaleBickeModel>BuyBikes;
    UpdateSelectedItem updateSelectedItem;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_buy_bikes_fragments, container, false);
        RecyclerView recyclerView;
        recyclerView=view.findViewById(R.id.RecyclerBuyBikes);
        recyclerView.setHasFixedSize(true);
        mStore=FirebaseStorage.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        BuyBikes=new ArrayList<>();
        BuyBikeAdapter adapter=new BuyBikeAdapter(BuyBikes,updateSelectedItem,getContext());
        recyclerView.setAdapter(adapter);
        FirebaseDatabase database;
        database=FirebaseDatabase.getInstance();

        obj=new DBFile();
        database.getReference("BuyBikes").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot FatchData:snapshot.getChildren()) {
                    String Model = FatchData.child("bikeModel").getValue(String.class);
                    String Image=FatchData.child("image").getValue(String.class);
                    Toast.makeText(getContext(), ""+Image, Toast.LENGTH_SHORT).show();
                    String Title=FatchData.child("bikeName").getValue(String.class);
                    Toast.makeText(getContext(), ""+Title, Toast.LENGTH_SHORT).show();
                    String des=FatchData.child("bikeDesc").getValue(String.class);
                    BuyBikes.add(new SaleBickeModel(Model,"120",des,Title,Image));

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}