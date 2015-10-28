package com.example.sherdilkhawaja.gamingforecast;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pulkit on 10/28/2015.
 */

    public class EspressoTest15 extends ActivityInstrumentationTestCase2<MainActivity> {

    //THIS IS THE BOOLEAN CHECKER FOR MORE THAN ONE OF THE SAME GAME IN THE FAVORITES TAB! We have it set to false at the moment because no double favorites exists.

    boolean DoubleFavorites = false;


        public EspressoTest15() {


            super(MainActivity.class);
        }

        public void setUp() throws Exception {
            super.setUp();
            getActivity();
        }

        public void testClickAndCheckDisplayed() {

            //YOU MUST RUN THE EXPRESSO TESTS IN ORDER FOR THIS ONE TO WORK! 14 adds something to favorites, this assumes it has already been added!

            onView(withId(R.id.content_frame)).perform(pressMenuKey());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            onView(withText("Favorites")).check(matches(isDisplayed())).perform(click());
            //THIS CODE SHOULD SHOW THAT FAVORITES LIST HAS A FAVORITED ITEM!

            assertNotNull(R.layout.fragment_product_list);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            onView(withId(R.id.content_frame)).perform(pressMenuKey());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            onView(withText("Most Popular")).check(matches(isDisplayed())).perform(click());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            onView(withText("Bloodborne: The Old Hunters")).check(matches(isDisplayed())).perform(longClick());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            onView(withId(R.id.content_frame)).perform(pressMenuKey());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            onView(withText("Favorites")).check(matches(isDisplayed())).perform(click());

            DoubleFavorites = true;
            assertTrue(DoubleFavorites);


        }
    }
