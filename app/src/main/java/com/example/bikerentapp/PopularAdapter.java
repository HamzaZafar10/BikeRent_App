package com.example.bikerentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.PopularViewHolder> {
    private Context context;
    private List<PopularModel> list;

    public PopularAdapter(Context context, List<PopularModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.activity_popular,null);

        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImagePop());
        holder.rating.setText(list.get(position).getRating());
        holder.username.setText(list.get(position).getUserName());
        holder.des.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView username,des,rating;
        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.profile_imageshow);
            username=itemView.findViewById(R.id.Usernameshow);
            des=itemView.findViewById(R.id.Descshow);
            rating=itemView.findViewById(R.id.LocationShow);
        }
    }

}

