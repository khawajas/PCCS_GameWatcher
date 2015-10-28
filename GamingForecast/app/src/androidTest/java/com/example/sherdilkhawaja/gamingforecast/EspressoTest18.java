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

//Scnenario: Multiple Game Alerts [Happy Path] for Reminder/Banner [IT 2]

public class EspressoTest18 extends ActivityInstrumentationTestCase2<Banner> {

    public EspressoTest18() {
        super(Banner.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }


    public void testClickAndCheckDisplayed() {


        //todo

    }
}

