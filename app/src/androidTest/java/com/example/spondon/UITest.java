package com.example.spondon;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    final Calendar cal = Calendar.getInstance();

    @Test
    public void testaddrecord(){
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.add)).check(matches(isDisplayed()));
        onView(withId(R.id.systolic)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolic)).perform(ViewActions.typeText("80"));
        onView(withId(R.id.heart)).perform(ViewActions.typeText("65"));
    }
}
