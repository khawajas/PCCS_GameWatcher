package com.example.sherdilkhawaja.gamingforecast;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.app.ListActivity;
import android.test.ActivityInstrumentationTestCase2;

//Scnenario: No Game Information Notice [Sad Path] for Game Information Page [IT 1]

public class EspressoTest5 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest5() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

    //code for favorites list
        onView(withId(R.id.list_product)).perform(click());
        //replace list_product with favorites list location.. cant find.


    }
}

