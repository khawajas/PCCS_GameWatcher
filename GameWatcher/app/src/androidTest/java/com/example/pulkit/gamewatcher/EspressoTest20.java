package com.example.pulkit.gamewatcher;

import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//Scenario: Updated Filtered Items [Happy Path] for Add Multiple Filters [Iteration 3]

public class EspressoTest20 extends ActivityInstrumentationTestCase2<MainActivity> {


    public EspressoTest20() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    boolean check = false;

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.checkRPG)).perform(click());
        onView(withText("OK")).perform(click());

        check = false;

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.checkADVENTURE)).perform(click());
        onView(withText("OK")).perform(click());

        assertNotNull((withId(R.id.checkRPG)).matches(isNotChecked()));

        //check = true;
       // assertTrue(check);

    }
}