package com.example.sherdilkhawaja.gamingforecast;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Tap;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Sherdil Khawaja on 10/19/2015.
 */
public class EspressoTest10 extends ActivityInstrumentationTestCase2<Banner> {

    public EspressoTest10() {

        super(Banner.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public static ViewAction clickXY(final int x, final int y) {
        return new GeneralClickAction(
                Tap.SINGLE, new CoordinatesProvider() {
            @Override
            public float[] calculateCoordinates(View view) {
                final int[] screenPos = new int[2];
                view.getLocationOnScreen(screenPos);

                final float screenX = screenPos[0] + x;
                final float screenY = screenPos[1] + y;
                float[] coordinates = {screenX, screenY};

                return coordinates;
            }
        }, Press.FINGER);
    }


    public void testClickAndCheckDisplayed() {

        ViewInteraction button1 = onView(withId(R.id.YoutubeButton)); // Find the button
        ViewInteraction helloWorldText = onView(withText("Youtube"));
        button1.perform(click());

        }
    }

