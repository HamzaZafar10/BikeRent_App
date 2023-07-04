package com.example.bikerentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BuyBikeAdapter extends RecyclerView.Adapter<BuyBikeAdapter.BuyBikeViewHolder> {
    private List<SaleBickeModel> ListItem;
    UpdateSelectedItem updateSelectedItem;
    Context applicationContext;
    public BuyBikeAdapter(List<SaleBickeModel>ListItem,UpdateSelectedItem updateSelectedItem,Context applicationContext)
    {
        this.ListItem=ListItem;
        this.updateSelectedItem = updateSelectedItem;
        this.applicationContext = applicationContext;

    }
    @NonNull
    @Override
    public BuyBikeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.buybikes,null);
        return new BuyBikeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyBikeViewHolder holder, int position) {
        SaleBickeModel temp=ListItem.get(position);
        holder.Name.setText(temp.getBikeName());
        holder.Price.setText(ListItem.get(position).getBikePrice());
        Picasso.get().load(ListItem.get(position).getImage()).into(holder.imageView);
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=temp.getBikeName();
                String price=temp.getBikePrice();
                String image=temp.getImage();

                ((UpdateSelectedItem) ApplicationMain.getContext()).addItem(name,price,image);
                Toast.makeText(v.getContext(), "Add To Cart", Toast.LENGTH_SHORT).show();
                holder.add.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ListItem.size();
    }

    public class BuyBikeViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView,add;
        private TextView Name,Price,model;
        public BuyBikeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.buyBikesImage);
            add=itemView.findViewById(R.id.Add_button_Item);
            Name=itemView.findViewById(R.id.NameBuyBikes);
            Price=itemView.findViewById(R.id.PriceBuyBikes);


        }
    }
}
