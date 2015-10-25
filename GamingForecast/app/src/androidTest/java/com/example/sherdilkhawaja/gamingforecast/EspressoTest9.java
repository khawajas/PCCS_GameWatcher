package com.example.sherdilkhawaja.gamingforecast;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.StringStartsWith.startsWith;

import android.app.ListActivity;
import android.test.ActivityInstrumentationTestCase2;

import org.hamcrest.Matchers;

//Scnenario: View a Trailer [Happy Path] for Add Video Preview [IT 1]

public class EspressoTest9 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest9() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {


        onView(withId(R.id.YoutubeButton)).perform(longClick());


    }
}

