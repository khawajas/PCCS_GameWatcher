package com.example.pulkit.gamewatcher;

import android.test.ActivityInstrumentationTestCase2;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pulkit on 11/25/2015.
 *
 * //Scenario: Refresh Upcoming Games [Happy Path]: for Upcoming Games [IT 3]
 */
public class EspressoTest27 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest27() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }


    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.content_frame)).perform(pressMenuKey());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Upcoming")).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Yes")).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.spinner)).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("January")).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        onView(withId(R.id.spinner)).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("March")).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.list_thismonth));

    }

}