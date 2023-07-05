package com.example.spondon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class update extends AppCompatActivity {

    EditText editsys;
    EditText editdia;
    EditText editheart;
    EditText edittime;
    EditText editdate;
    EditText editcomment;
    Button con;
    String receivedkey;

    final Calendar cal = Calendar.getInstance();
    private EditText datePicker, timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        datePicker = findViewById(R.id.cur_date);
        timePicker = findViewById(R.id.cur_time);
        editsys = findViewById(R.id.systolic);
        editsys.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this example
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used in this example
            }

            @Override
            public void afterTextChanged(Editable s) {
                String inputString = s.toString();
                if (!inputString.isEmpty()) {
                    int input = Integer.parseInt(inputString);
                    if (input < 50 || input > 200) {
                        editsys.setError("between 50 and 200");
                    } else {
                        editsys.setError(null); // Clear any previous error
                    }
                }
            }
        });
        editdia = findViewById(R.id.diastolic);
        editdia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this example
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used in this example
            }

            @Override
            public void afterTextChanged(Editable s) {
                String inputString = s.toString();
                if (!inputString.isEmpty()) {
                    int input = Integer.parseInt(inputString);
                    if (input < 50 || input > 200) {
                        editdia.setError("between 50 and 200");
                    } else {
                        editdia.setError(null); // Clear any previous error
                    }
                }
            }
        });
        editheart = findViewById(R.id.heart);
        editheart.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this example
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Not used in this example
            }

            @Override
            public void afterTextChanged(Editable s) {
                String inputString = s.toString();
                if (!inputString.isEmpty()) {
                    int input = Integer.parseInt(inputString);
                    if (input < 50 || input > 200) {
                        editheart.setError("between 50 and 200");
                    } else {
                        editheart.setError(null); // Clear any previous error
                    }
                }
            }
        });
        edittime = findViewById(R.id.cur_time);
        editdate = findViewById(R.id.cur_date);
        editcomment = findViewById(R.id.comment);
        con = findViewById(R.id.confirm);

        Intent intent = getIntent();

        selectDate();

        timePicker.setOnClickListener(y->selectTime());

        if (intent != null) {
            editsys.setText(intent.getStringExtra("systolic"));
            editdia.setText(intent.getStringExtra("diastolic"));
            editheart.setText(intent.getStringExtra("heart"));
            editdate.setText(intent.getStringExtra("date"));
            edittime.setText(intent.getStringExtra("time"));
            editcomment.setText(intent.getStringExtra("comment"));
            receivedkey = intent.getStringExtra("key");
        }

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference("records").child(receivedkey);
                HashMap<String, Object> updates = new HashMap<>();
                updates.put("comment", editcomment.getText());
                updates.put("date", editdate.getText());
                updates.put("time", edittime.getText());
                updates.put("heart", editheart.getText());
                updates.put("diastolic_blood_pressure", editdia.getText());
                updates.put("systolic_blood_pressure", editsys.getText());

                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Item record = snapshot.getValue(Item.class);
                            record.setComment(editcomment.getText().toString());
                            record.setDate(editdate.getText().toString());
                            record.setDiastolic_blood_pressure(editdia.getText().toString());
                            record.setHeart_rate(editheart.getText().toString());
                            record.setSystolic_blood_pressure(editsys.getText().toString());
                            record.setTime(edittime.getText().toString());

                            db.setValue(record).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(update.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(update.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(update.this, "Update Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

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
                new DatePickerDialog(update.this,date,cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR)).show();
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
        timePickerDialog = new TimePickerDialog(update.this, new TimePickerDialog.OnTimeSetListener() {
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