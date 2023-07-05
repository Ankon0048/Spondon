package com.example.spondon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
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
        int dianumber = Integer.parseInt(items.get(position).getDiastolic_blood_pressure());
        if(dianumber<60 || dianumber>90){
            holder.diastolic_blood_pressures.setText(items.get(position).getDiastolic_blood_pressure());
            holder.diastolic_blood_pressures.setTextColor(Color.RED);
            holder.dia.setTextColor(Color.RED);
        }
        else{
            holder.diastolic_blood_pressures.setText(items.get(position).getDiastolic_blood_pressure());
            holder.diastolic_blood_pressures.setTextColor(Color.GREEN);
            holder.dia.setTextColor(Color.GREEN);
        }
        int sysnumber = Integer.parseInt(items.get(position).getSystolic_blood_pressure());
        if(sysnumber<90 || sysnumber>140){
            holder.systolic_blood_pressures.setText(items.get(position).getSystolic_blood_pressure());
            holder.systolic_blood_pressures.setTextColor(Color.RED);
            holder.sys.setTextColor(Color.RED);
        }
        else{
            holder.systolic_blood_pressures.setText(items.get(position).getSystolic_blood_pressure());
            holder.systolic_blood_pressures.setTextColor(Color.GREEN);
            holder.sys.setTextColor(Color.GREEN);
        }
        holder.heart_rates.setText(items.get(position).getHeart_rate());
        holder.dates.setText(items.get(position).getDate());
        holder.times.setText(items.get(position).getTime());
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("records").child(items.get(holder.getBindingAdapterPosition()).getKey());
                Task<Void> mtask = db.removeValue();
                mtask.addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        holder.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("records").child(items.get(holder.getBindingAdapterPosition()).getKey());
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Intent intent = new Intent(context, update.class);
                            intent.putExtra("systolic", snapshot.child("systolic_blood_pressure").getValue(String.class));
                            intent.putExtra("diastolic", snapshot.child("diastolic_blood_pressure").getValue(String.class));
                            intent.putExtra("heart", snapshot.child("heart_rate").getValue(String.class));
                            intent.putExtra("date", snapshot.child("date").getValue(String.class));
                            intent.putExtra("time", snapshot.child("time").getValue(String.class));
                            intent.putExtra("comment", snapshot.child("comment").getValue(String.class));
                            intent.putExtra("key", snapshot.child("key").getValue(String.class));
                            context.startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(context, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("records").child(items.get(holder.getBindingAdapterPosition()).getKey());
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Intent intent = new Intent(context, show.class);
                            intent.putExtra("systolic", snapshot.child("systolic_blood_pressure").getValue(String.class));
                            intent.putExtra("diastolic", snapshot.child("diastolic_blood_pressure").getValue(String.class));
                            intent.putExtra("heart", snapshot.child("heart_rate").getValue(String.class));
                            intent.putExtra("date", snapshot.child("date").getValue(String.class));
                            intent.putExtra("time", snapshot.child("time").getValue(String.class));
                            intent.putExtra("comment", snapshot.child("comment").getValue(String.class));
                            context.startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(context, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
