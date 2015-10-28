package com.example.sherdilkhawaja.gamingforecast;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressMenuKey;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

//Scnenario: Banner/Notification Interaction (When device is unlocked OR locked) [Happy Path] for Reminder/Banner [IT 2]

public class EspressoTest17 extends ActivityInstrumentationTestCase2<Banner> {

    public EspressoTest17() {
        super(Banner.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }


        public void testClickAndCheckDisplayed () {


            //todo

        }
    }

