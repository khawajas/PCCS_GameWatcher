package com.example.pulkit.gamewatcher;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//Scenario: Check Box Filter [Happy Path] for Add Multiple Filters [Iteration 3]

public class EspressoTest19 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest19() {
        super(MainActivity.class);
    }

    boolean check = false;

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.checkRPG)).perform(click());
        onView(withText("OK")).perform(click());

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull("RPG", R.id.list_product);

    }
}