package com.example.spondon;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.os.SystemClock;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@LargeTest
public class uiTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testaddrecord(){

        onView(withId(R.id.main)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.add)).check(matches(isDisplayed()));
        onView(withId(R.id.systolic)).perform(ViewActions.typeText("120"));
        onView(withId(R.id.diastolic)).perform(ViewActions.typeText("80"));
        onView(withId(R.id.heart)).perform(ViewActions.typeText("65"));
        onView(withId(R.id.cur_date)).perform(ViewActions.typeText("22-07-2023"));
        Espresso.pressBack();
        onView(withId(R.id.cur_time)).perform(ViewActions.typeText("10:52"));
        Espresso.pressBack();
        onView(withId(R.id.comment)).perform(ViewActions.typeText("Heyo"));
        Espresso.pressBack();

        onView(withId(R.id.confirm)).perform(click());
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }


    @Test
    public void testupdaterecord(){
        onView(withId(R.id.main)).check(matches(isDisplayed()));
        SystemClock.sleep(5000);
        onView(withId(R.id.recyclerview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0,MyViewAction.clickChildViewWithId(R.id.edit)));
        onView(withId(R.id.update)).check(matches(isDisplayed()));

        onView(withId(R.id.systolic)).perform(clearText());
        onView(withId(R.id.systolic)).perform(ViewActions.typeText("60"));

        onView(withId(R.id.diastolic)).perform(clearText());
        onView(withId(R.id.diastolic)).perform(ViewActions.typeText("70"));

        onView(withId(R.id.heart)).perform(clearText());
        onView(withId(R.id.heart)).perform(ViewActions.typeText("80"));

        onView(withId(R.id.cur_date)).perform(clearText());
        onView(withId(R.id.cur_date)).perform(ViewActions.typeText("02-12-2001"));
        Espresso.pressBack();
        onView(withId(R.id.cur_time)).perform(clearText());
        onView(withId(R.id.cur_time)).perform(ViewActions.typeText("11:00"));
        Espresso.pressBack();
        onView(withId(R.id.comment)).perform(clearText());
        onView(withId(R.id.comment)).perform(ViewActions.typeText("Resting"));
        Espresso.pressBack();

        onView(withId(R.id.confirm)).perform(click());

        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }


    public static class MyViewAction {

        /**
         * view action test
         * @param id
         * @return
         */
        public static ViewAction clickChildViewWithId(final int id) {
            /**
             * view action creator
             */
            return new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return ViewMatchers.isAssignableFrom(RecyclerView.class);
                }

                /**
                 * description getter
                 * @return
                 */
                @Override
                public String getDescription() {
                    return "Click on a child view with specified id.";
                }

                /**
                 * performer
                 * @param uiController the controller to use to interact with the UI.
                 * @param view the view to act upon. never null.
                 */
                @Override
                public void perform(UiController uiController, View view) {
                    View v = view.findViewById(id);
                    v.performClick();
                }
            };
        }
    }
}
