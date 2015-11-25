package com.example.pulkit.gamewatcher;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//Scenario: No Suggestions [Happy Path] for Recommended/Suggested Tab [Iteration 3]
//NOTE: Make sure nothing is favourited

public class EspressoTest24 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest24() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    boolean check = false;

    public void testClickAndCheckDisplayed() {


        onView(withId(R.id.content_frame)).perform(pressMenuKey());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Suggested")).check(matches(isDisplayed())).perform(click());

        assertNotNull("No current suggestions for you!", R.string.no_suggested_msg);
        assertNotNull("Please check again later!", R.string.comeback);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("OK")).perform(click());

        onView(withId(R.id.content_frame));
        check = true;

        assertTrue(check);


    }

}