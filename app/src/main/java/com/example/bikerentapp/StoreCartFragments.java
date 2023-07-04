package com.example.bikerentapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StoreCartFragments extends Fragment {
    Activity context;
    TextView Payment,parcentage,grandTotal,TextParsentage,GrandTotalPayment;
    Button ConformButton;
    OrderAdapter adapter;
    public static double total=0;
    public static double Qunitity;
    TextView paymentCard;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_store_cart_fragments, container, false);
        RecyclerView recyclerView;
        recyclerView=view.findViewById(R.id.RecyclerConform);
        Payment=view.findViewById(R.id.paymentCard);
        parcentage=view.findViewById(R.id.TextParsentage);
        grandTotal=view.findViewById(R.id.GrandTotalPayment);
        ConformButton=view.findViewById(R.id.ConformButton);
        paymentCard=view.findViewById(R.id.paymentCard);
        button=view.findViewById(R.id.ConformButton);
        TextParsentage=view.findViewById(R.id.TextParsentage);
        GrandTotalPayment=view.findViewById(R.id.GrandTotalPayment);
        adapter=new OrderAdapter(context);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentCard.setText("Rs:"+total);
                double text=total*0.15;
                TextParsentage.setText(text+"%");
                double finalPrice=text+total;
                GrandTotalPayment.setText("Rs:"+finalPrice);

            }

        });


        return view;
    }
}