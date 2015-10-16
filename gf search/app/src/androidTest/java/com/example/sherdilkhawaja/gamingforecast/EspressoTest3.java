package com.example.sherdilkhawaja.gamingforecast;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.app.ListActivity;
import android.test.ActivityInstrumentationTestCase2;

//Scnenario: Horizontal Interaction [Sad Path] for Interactive Home Screen/Favorites Screen [IT 1]

public class EspressoTest3 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest3() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.list_product)).perform(swipeLeft());
        onView(withId(R.id.list_product)).perform(swipeRight());
        assertNotNull(R.id.list_product);

    }
}

