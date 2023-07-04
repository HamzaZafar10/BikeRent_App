package com.example.bikerentapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DashbordMainFaragments extends Fragment implements OnTextClickListener{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View view=inflater.inflate(R.layout.fragment_dashbord_main_faragments, container, false);
        RecyclerView CatRecyclerView;
        CatRecyclerView=view.findViewById(R.id.CategoriesRecyclerView);
        CatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        List<CatagorieModel> list=new ArrayList<>();
        list.add(new CatagorieModel(R.drawable.parts,"Bike Parts"));
        list.add(new CatagorieModel(R.drawable.bike2,"Buy Bikes"));
        list.add(new CatagorieModel(R.drawable.buybikes,"Rent Bikes"));

        CatagoireAdapter adapter=new CatagoireAdapter(getContext(),list,this);
        CatRecyclerView.setAdapter(adapter);

        RecyclerView PopulatRecyelerView;
        PopulatRecyelerView=view.findViewById(R.id.RecyclerViewPopular);
        PopulatRecyelerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        List<PopularModel> listPop=new ArrayList<>();

        listPop.add(new PopularModel("Honda 125","4.5",R.drawable.honda,"to brilliant"));
        listPop.add(new PopularModel("CD 70","4.5",R.drawable.moter1,"to brilliant"));
        listPop.add(new PopularModel("Road prince","4.5",R.drawable.roadprince,"to brilliant"));
        listPop.add(new PopularModel("RXD210","4.5",R.drawable.moter2,"to brilliant"));

        PopularAdapter adapter1=new PopularAdapter(getContext(),listPop);
        PopulatRecyelerView.setAdapter(adapter1);


        return view;

    }

    @Override
    public void onTextClick(CatagorieModel Text) {

        if(Text.getTitleName().toString().equals("Rent Bikes"))
        {
            Toast.makeText(getContext(), "Rent Bikes", Toast.LENGTH_SHORT).show();
             RentBikeFragments rentBikeFragments=new RentBikeFragments();
            getFragmentManager().beginTransaction().replace(R.id.frameLayout,rentBikeFragments).commit();
        }

        if(Text.getTitleName().toString().equals("Bike Parts"))
        {
            Toast.makeText(getContext(), "Bike Parts", Toast.LENGTH_SHORT).show();
             BikePartFragments bikePartFragments=new BikePartFragments();
            getFragmentManager().beginTransaction().replace(R.id.frameLayout,bikePartFragments).commit();
        }

        if(Text.getTitleName().toString().equals("Buy Bikes"))
        {
            Toast.makeText(getContext(), "Make Up", Toast.LENGTH_SHORT).show();
            BuyBikesFragments buyBikesFragments=new BuyBikesFragments();
            getFragmentManager().beginTransaction().replace(R.id.frameLayout,buyBikesFragments).commit();
        }
    }
    }
