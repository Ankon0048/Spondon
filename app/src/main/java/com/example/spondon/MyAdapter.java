package com.example.spondon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.diastolic_blood_pressures.setText(items.get(position).getDiastolic_blood_pressure());
        holder.systolic_blood_pressures.setText(items.get(position).getSystolic_blood_pressure());
        holder.heart_rates.setText(items.get(position).getHeart_rate());
        holder.dates.setText(items.get(position).getDate());
        holder.times.setText(items.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
