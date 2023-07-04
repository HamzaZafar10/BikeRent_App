package com.example.bikerentapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatagoireAdapter extends RecyclerView.Adapter<CatagoireAdapter.CategorieViewHolder> {
    private Context context;
    private List<CatagorieModel> list;
    OnTextClickListener listener;

    public CatagoireAdapter(Context context, List<CatagorieModel> list,OnTextClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CategorieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.categoire_show_desgin,null);
        return new CategorieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView.setText(list.get(position).getTitleName());
        holder.imageView.setImageResource(list.get(position).getImage());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Text=holder.textView.getText().toString();

                CatagorieModel  data = list.get(position);
                listener.onTextClick(data);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CategorieViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public CategorieViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.ImaeCategorieShow);
            textView=itemView.findViewById(R.id.TitleShowCategorie);
        }
    }
}
