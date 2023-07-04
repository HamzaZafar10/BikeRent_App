package com.example.bikerentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.AdminVIewHolder> {
    List<AdminViewModel>list;
    public AdminAdapter(List<AdminViewModel>list)
    {
        this.list=list;
    }
    @NonNull
    @Override
    public AdminVIewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.adminviewdesine,null);
        return new AdminVIewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminVIewHolder holder, int position) {

        AdminViewModel temp=list.get(position);
        holder.textView.setText(list.get(position).getText());
        holder.imageView.setImageResource(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdminVIewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public AdminVIewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.AdminImage);
            textView=itemView.findViewById(R.id.adminText);

        }
    }
}
