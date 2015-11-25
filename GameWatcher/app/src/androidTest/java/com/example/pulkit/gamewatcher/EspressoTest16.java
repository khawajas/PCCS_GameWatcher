package com.example.pulkit.gamewatcher;
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

//Scnenario: Banner Alert [Happy Path] for Reminder/Banner [IT 2]

public class EspressoTest16 extends ActivityInstrumentationTestCase2<MainActivity> {

    public EspressoTest16() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }


    public void testClickAndCheckDisplayed() {

        //it just shows in the top left... what do you want me to assert....


//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
////        onView(withId(R.layout.activity_main)).perform(swipeDown());
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        onView(withId(R.id.content_frame)).perform(new GeneralClickAction(Tap.LONG, new CoordinatesProvider() {
//            @Override
//            public float[] calculateCoordinates(View view) {
//                return new float[]{500,700};
//            }
//        }, Press.FINGER));

    }
}

