package com.example.spondon;

public class Item {
    String systolic_blood_pressure;
    String diastolic_blood_pressure;
    String heart_rate;
    String date;
    String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Item(String systolic_blood_pressure, String diastolic_blood_pressure, String heart_rate,String date, String time) {
        this.systolic_blood_pressure = systolic_blood_pressure;
        this.diastolic_blood_pressure = diastolic_blood_pressure;
        this.heart_rate = heart_rate;
        this.date = date;
        this.time = time;
    }


    public String getSystolic_blood_pressure() {
        return systolic_blood_pressure;
    }

    public void setSystolic_blood_pressure(String systolic_blood_pressure) {
        this.systolic_blood_pressure = systolic_blood_pressure;
    }

    public String getDiastolic_blood_pressure() {
        return diastolic_blood_pressure;
    }

    public void setDiastolic_blood_pressure(String diastolic_blood_pressure) {
        this.diastolic_blood_pressure = diastolic_blood_pressure;
    }

    public String getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(String heart_rate) {
        this.heart_rate = heart_rate;
    }
}
