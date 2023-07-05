package com.example.spondon;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    @Test
    public void createItem_ObjectInitializedWithCorrectValues() {
        // Arrange
        String systolicBP = "120";
        String diastolicBP = "80";
        String heartRate = "75";
        String date = "2023-07-06";
        String time = "09:30 AM";
        String key = "abc123";
        String comment = "This is a comment.";

        // Act
        Item item = new Item(systolicBP, diastolicBP, heartRate, date, time, key, comment);

        // Assert
        assertEquals(systolicBP, item.getSystolic_blood_pressure());
        assertEquals(diastolicBP, item.getDiastolic_blood_pressure());
        assertEquals(heartRate, item.getHeart_rate());
        assertEquals(date, item.getDate());
        assertEquals(time, item.getTime());
        assertEquals(key, item.getKey());
        assertEquals(comment, item.getComment());
    }

    @Test
    public void testGetSystolicBloodPressure() {
        Item item = new Item();
        item.setSystolic_blood_pressure("120");

        String result = item.getSystolic_blood_pressure();

        assertEquals("120", result);
    }

    @Test
    public void testSetSystolicBloodPressure() {
        Item item = new Item();

        item.setSystolic_blood_pressure("120");

        String result = item.getSystolic_blood_pressure();

        assertEquals("120", result);
    }

    @Test
    public void testGetDiastolicBloodPressure() {
        Item item = new Item();
        item.setDiastolic_blood_pressure("80");

        String result = item.getDiastolic_blood_pressure();

        assertEquals("80", result);
    }

    @Test
    public void testSetDiastolicBloodPressure() {
        Item item = new Item();

        item.setDiastolic_blood_pressure("80");

        String result = item.getDiastolic_blood_pressure();

        assertEquals("80", result);
    }

    @Test
    public void testGetHeartRate() {
        Item item = new Item();
        item.setHeart_rate("70");

        String result = item.getHeart_rate();

        assertEquals("70", result);
    }

    @Test
    public void testSetHeartRate() {
        Item item = new Item();

        item.setHeart_rate("70");

        String result = item.getHeart_rate();

        assertEquals("70", result);
    }
}
