package com.example.bikerentapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RentAdapter extends RecyclerView.Adapter<RentAdapter.RenterViewHolder> {
    List<RentBikeModel>list;
    public RentAdapter(List<RentBikeModel>rentBikeModelList)
    {
        list=rentBikeModelList;
    }
    @NonNull
    @Override
    public RenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.rent_bike,null);
        return new RenterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RenterViewHolder holder, int position) {
        RentBikeModel temp=list.get(position);
        holder.Name.setText(list.get(position).getRenterName());
        holder.perPersone.setText(temp.getRentPrice());
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);
        holder.Appoin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(),AppointmentViewActivty.class);
                intent.putExtra("NameBike",temp.getBikeName());
                intent.putExtra("PriceRent",temp.getRentPrice());
                intent.putExtra("ImagePro",temp.getImage());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RenterViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView,Appoin_button;
        private TextView Name,perPersone,Phone;

        public RenterViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.profile_imageshowEmployee);
            perPersone=itemView.findViewById(R.id.PerPerson);
            Name=itemView.findViewById(R.id.Name);
            Appoin_button=itemView.findViewById(R.id.Appoin_button_Makup);
        }
    }
}
