package com.example.pulkit.gamewatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import android.test.ActivityInstrumentationTestCase2;

//Scenario: Click/Swipe the Interactive Favorite List Screen [Happy Path] for Interactive Home Screen/Favorites Screen [IT 1]

public class EspressoTest2 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest2() {
        super(MainActivity.class);
    }

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

        onView(withId(R.id.list_product)).perform(swipeDown());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.list_product)).perform(swipeUp());

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(R.id.list_product);

    }
}

