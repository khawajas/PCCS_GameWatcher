package com.example.pulkit.gamewatcher;


import android.test.ActivityInstrumentationTestCase2;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//Scenario: Search Bar Cancellation [Happy Path] for Search for Game Title [IT 2]

public class EspressoTest12 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest12() {


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
        onView(withText("Search")).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.searchbar)).check(matches(isDisplayed())).perform(click());
        onView(withId(R.id.searchbar)).perform(typeTextIntoFocusedView("l"));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(withText("l")).perform(clearText());


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(R.id.list_view2);


    }
}