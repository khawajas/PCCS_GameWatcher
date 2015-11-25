package com.example.pulkit.gamewatcher;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//Scenario: Multiple Suggested Item Genres [Sad Path] for Recommended/Suggested Tab [Iteration 3]

//NOTE: Make sure when you run this, nothing is favourited

public class EspressoTest23 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest23() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    boolean check = false;

    public void testClickAndCheckDisplayed() {

        onView(withText("Bloodborne: The Old Hunters")).check(matches(isDisplayed())).perform(longClick());
        onView(withText("Kingdom Hearts III")).check(matches(isDisplayed())).perform(longClick());

        onView(withId(R.id.content_frame)).perform(pressMenuKey());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Suggested")).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Adventure")).check((doesNotExist()));
        check = true;

        assertTrue(check);
    }

}