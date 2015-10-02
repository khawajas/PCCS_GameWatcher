package com.example.sherdilkhawaja.gamingforecast;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.doubleClick;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringStartsWith.startsWith;

import android.app.ListActivity;
import android.test.ActivityInstrumentationTestCase2;

import org.hamcrest.Matchers;

//Scnenario: Pop up Redirect [Sad Path] for Game Information Page [IT 1]

public class EspressoTest6 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest6() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.list_product)).perform(doubleClick());
        assertNotNull(R.id.list_product);
    }
}

