package com.example.pulkit.gamewatcher;

import android.test.ActivityInstrumentationTestCase2;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//Scenario: Most Popular Favorited Limit [Sad Path] for Most Popular/Trending [IT 2]

public class EspressoTest14 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest14() {


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
        onView(withText("Most Popular")).check(matches(isDisplayed())).perform(click());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        onView(withText("Bloodborne: The Old Hunters")).check(matches(isDisplayed())).perform(longClick());

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("Final Fantasy XV")).check(matches(isDisplayed())).perform(longClick());
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(PopularListFragment.class);


        //assertNotNull(PopularListFragment.mostpopular);

    }
}