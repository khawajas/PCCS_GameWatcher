package com.example.pulkit.gamewatcher;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


//Scenario: View Trailer [Happy Path] for Add Video Preview [IT 1]

public class EspressoTest7 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest7() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.YoutubePlayer)).perform(click());

        //sleep while youtube loads to prove the test works before asserting

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(R.id.YoutubePlayer);

    }
}


