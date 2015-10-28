package com.example.sherdilkhawaja.gamingforecast;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.app.ListActivity;
import android.support.test.espresso.Espresso;
import android.test.ActivityInstrumentationTestCase2;

//Scnenario: Gaming Forecast Accidental Close [Sad Path] for Interactive Home Screen/Favorites Screen [IT 1]

public class EspressoTest3 extends ActivityInstrumentationTestCase2<MainActivity> {

    boolean backSpam = false;

    public EspressoTest3() {
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

        onView(withText("Search")).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.content_frame)).perform(pressBack());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pressBack();
        pressBack();
        pressBack();
        pressBack();

        backSpam = true;
        assertTrue(backSpam);

    }
}

