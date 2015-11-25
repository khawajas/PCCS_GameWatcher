package com.example.pulkit.gamewatcher;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import android.test.ActivityInstrumentationTestCase2;

//Scenario: Return to App From Video [Happy Path] for Add Video Preview [IT 1]

public class EspressoTest9 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest9() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {


        onView(withId(R.id.YoutubePlayer)).perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewActions.pressBack();
        pressBack();
        Espresso.pressBack();
        onView(withId(R.id.content_frame)).perform(ViewActions.pressBack());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(R.id.YoutubePlayer);

    }
}

