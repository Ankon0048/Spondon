package com.example.spondon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class show extends AppCompatActivity {

    TextView editsys;
    TextView editdia;
    TextView editheart;
    TextView edittime;
    TextView editdate;
    TextView editcomment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        editsys = findViewById(R.id.systolic_blood_pressure);
        editdia = findViewById(R.id.diastolic_blood_pressure);
        editheart = findViewById(R.id.heart_rate);
        edittime = findViewById(R.id.time);
        editdate = findViewById(R.id.date);
        editcomment = findViewById(R.id.commentsh);

        Intent intent = getIntent();
        if (intent != null) {
            editsys.setText(intent.getStringExtra("systolic"));
            editdia.setText(intent.getStringExtra("diastolic"));
            editheart.setText(intent.getStringExtra("heart"));
            editdate.setText(intent.getStringExtra("date"));
            edittime.setText(intent.getStringExtra("time"));
            editcomment.setText(intent.getStringExtra("comment"));
        }

    }
}