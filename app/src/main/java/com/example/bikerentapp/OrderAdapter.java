package com.example.bikerentapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OderViewHolder> {

    ArrayList<OrderConformModel> orderConformModels;
    Activity activity;
    private int Count=1;
    int i=0;
    public OrderAdapter(Activity activity) {

        this.activity = activity;
        orderConformModels= ((UpdateSelectedItem) ApplicationMain.getContext()).getItem();
    }

    @NonNull
    @Override
    public OderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.order_desgine,null);
        return new OderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OderViewHolder holder, int position) {

        Picasso.get().load(orderConformModels.get(position).getImage()).into(holder.imageView);
        holder.price.setText(orderConformModels.get(position).getPrice());
        holder.title.setText(orderConformModels.get(position).getProductName());

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count= Count ++;
                holder.Quinity.setText(""+Count);
            }
        });

        holder.Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Count>1)
                {
                    Count=Count--;
                    holder.Quinity.setText(""+Count);

                }
            }
        });

        StoreCartFragments.total=0;
        for (int i =0 ; i <position+1 ; i ++ ) {
            StoreCartFragments.total = StoreCartFragments.total+Double.parseDouble(orderConformModels.get(i).getPrice());
            StoreCartFragments.Qunitity = StoreCartFragments.Qunitity+Double.parseDouble(orderConformModels.get(i).getPrice());

        }


    }

    @NonNull

    @Override
    public int getItemCount() {
        return orderConformModels.size();
    }

    public class OderViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView title,price,Quinity;
        private ImageButton plus,Minus;
        public OderViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.TextShowCard);
            price=itemView.findViewById(R.id.PriceCardShow);
            imageView=itemView.findViewById(R.id.ImageCard);
            plus=itemView.findViewById(R.id.plusBtn);
            Minus=itemView.findViewById(R.id.MinusBtn);
            Quinity=itemView.findViewById(R.id.Quinity);


        }
    }
}
