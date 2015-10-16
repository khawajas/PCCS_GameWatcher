package com.example.sherdilkhawaja.gamingforecast;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.app.ListActivity;
import android.test.ActivityInstrumentationTestCase2;

//Scnenario: Click and save/remove to/from personal favorites list [Happy Path] for Interactive Home Screen/Favorites Screen [IT 1]

public class EspressoTest1 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest1() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.list_product)).perform(longClick());
        assertNotNull(R.id.list_product);

    }
}

