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

public class BikePartFragments extends Fragment {
    FirebaseStorage mStore;
    DBFile obj;
    int price2;
    List<ItemModel>BikePartsList;
    UpdateSelectedItem updateSelectedItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_bike_part_fragments, container, false);
        RecyclerView recyclerView;
        recyclerView=view.findViewById(R.id.RecyclerItem);
        recyclerView.setHasFixedSize(true);
        mStore=FirebaseStorage.getInstance();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        BikePartsList=new ArrayList<>();
        ItemAdapter adapter=new ItemAdapter(BikePartsList,updateSelectedItem,getContext());
        recyclerView.setAdapter(adapter);
        FirebaseDatabase database;
        database=FirebaseDatabase.getInstance();

        obj=new DBFile();
        database.getReference("Item").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot FatchData:snapshot.getChildren()) {
                    ItemModel model = FatchData.getValue(ItemModel.class);
                    String desc = FatchData.child("desc").getValue(String.class);
                    String Image=FatchData.child("image").getValue(String.class);
                    Toast.makeText(getContext(), ""+Image, Toast.LENGTH_SHORT).show();
                    String Title=FatchData.child("title").getValue(String.class);
                    Integer a= FatchData.child("price").getValue(Integer.class);
                    Toast.makeText(getContext(), "value"+a, Toast.LENGTH_SHORT).show();
                    String price=String.valueOf(a);
                    BikePartsList.add(new ItemModel(Image,Title,desc,price));

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