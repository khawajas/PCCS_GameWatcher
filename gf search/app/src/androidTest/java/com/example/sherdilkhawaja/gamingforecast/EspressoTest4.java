package com.example.sherdilkhawaja.gamingforecast;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.app.ListActivity;
import android.test.ActivityInstrumentationTestCase2;

//Scnenario: Game Information Notice [Happy Path] for Game Information Page [IT 1]

public class EspressoTest4 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest4() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.list_product)).perform(click());
        assertNotNull(R.id.list_product);

    }
}

