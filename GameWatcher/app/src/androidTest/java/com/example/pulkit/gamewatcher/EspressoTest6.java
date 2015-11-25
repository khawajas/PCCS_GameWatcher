package com.example.pulkit.gamewatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.test.ActivityInstrumentationTestCase2;

//Scenario: Pop up Redirect [Sad Path] for Game Information Page [IT 1]

public class EspressoTest6 extends ActivityInstrumentationTestCase2<MainActivity> {

    boolean Spammer = false;

    public EspressoTest6() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.list_product)).perform(click());
        onView(withId(R.id.content_frame)).perform(pressMenuKey());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withText("Search")).check(matches(isDisplayed())).perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Spammer = true;
        assertTrue(Spammer);


    }
}

