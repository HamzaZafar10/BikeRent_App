package com.example.bikerentapp;

import android.content.Context;
import android.content.Intent;
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

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<ItemModel>ListItem;
    UpdateSelectedItem updateSelectedItem;
    Context applicationContext;
    public ItemAdapter(List<ItemModel>LisyItem,UpdateSelectedItem updateSelectedItem,Context applicationContext)
    {
        this.ListItem=LisyItem;
        this.updateSelectedItem = updateSelectedItem;
        this.applicationContext = applicationContext;

    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.desgin_item,null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        ItemModel temp=ListItem.get(position);
        holder.Name.setText(ListItem.get(position).getTitle());
        holder.Price.setText(ListItem.get(position).getPriceShow());
        Picasso.get().load(ListItem.get(position).getImage()).into(holder.imageView);
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=temp.getTitle();
                String price=temp.getPriceShow();
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

    public class ItemViewHolder extends RecyclerView.ViewHolder{
    private ImageView imageView,add;
    private TextView Name,Price;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.profile_imageshowEmployee);
        add=itemView.findViewById(R.id.Add_button_Item);
        Name=itemView.findViewById(R.id.NameItem);
        Price=itemView.findViewById(R.id.PriceItem);
    }
}
}
