package com.example.spondon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView systolic_blood_pressures;
    TextView diastolic_blood_pressures;
    TextView heart_rates;
    TextView dates;
    TextView times;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        systolic_blood_pressures = itemView.findViewById(R.id.systolic_blood_pressure);
        diastolic_blood_pressures = itemView.findViewById(R.id.diastolic_blood_pressure);
        heart_rates = itemView.findViewById(R.id.heart_rate);
        dates = itemView.findViewById(R.id.date);
        times = itemView.findViewById(R.id.time);
    }
}
