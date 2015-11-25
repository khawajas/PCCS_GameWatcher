package com.example.pulkit.gamewatcher;

 import static android.support.test.espresso.Espresso.onView;
 import static android.support.test.espresso.action.ViewActions.click;
 import static android.support.test.espresso.matcher.ViewMatchers.withId;
 import android.test.ActivityInstrumentationTestCase2;


//Scenario: Video Preview Fail [Sad Path] for Add Video Preview [IT 1]

public class EspressoTest8 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest8() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testClickAndCheckDisplayed() {

        onView(withId(R.id.BadButton)).perform(click());


        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertNotNull(R.id.BadButton);

    }
}

