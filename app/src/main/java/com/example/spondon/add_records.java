package com.example.spondon;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class add_records extends AppCompatActivity {

    final Calendar cal = Calendar.getInstance();
    private EditText datePicker, timePicker;
    private EditText systolic, diastolic,heart,comment;
    private Button confirm;
    DatabaseReference sprecordDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_records);


        datePicker = findViewById(R.id.cur_date);
        timePicker = findViewById(R.id.cur_time);
        systolic = findViewById(R.id.systolic);
        diastolic = findViewById(R.id.diastolic);
        heart = findViewById(R.id.heart);
        comment = findViewById(R.id.comment);
        confirm = (Button) findViewById(R.id.confirm);

        sprecordDbRef = FirebaseDatabase.getInstance().getReference().child("records");

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        selectDate();

        timePicker.setOnClickListener(y->selectTime());
    }

    private void insertData(){

        String tempsystolic = systolic.getText().toString();
        String tempdiastolic = diastolic.getText().toString();
        String tempheart = heart.getText().toString();
        String tempdatePicker = datePicker.getText().toString();
        String temptimePicker = timePicker.getText().toString();
        String tempcomment = comment.getText().toString();


        Item items = new Item(tempsystolic,tempdiastolic,tempheart,tempdatePicker,temptimePicker);

        sprecordDbRef.push().setValue(items).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())  Toast.makeText(add_records.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                else  Toast.makeText(add_records.this, "Data Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectDate(){
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                datePicker.setText(updateDate());
            }
        };

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(add_records.this,date,cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR)).show();
            }
        });
    }

    private String updateDate(){
        String format = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }

    private void selectTime(){
        Calendar caltime = Calendar.getInstance();
        int hour = caltime.get(Calendar.HOUR);
        int min = caltime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog;
        timePickerDialog = new TimePickerDialog(add_records.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int min) {
                caltime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                caltime.set(Calendar.MINUTE, min);

                String myFormat = "HH:mm:ss";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat);
                timePicker.setText(simpleDateFormat.format(caltime.getTime()));
            }
        },hour,min,true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
}
