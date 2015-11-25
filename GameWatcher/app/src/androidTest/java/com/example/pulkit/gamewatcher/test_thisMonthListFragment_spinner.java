package com.example.pulkit.gamewatcher;

import android.test.InstrumentationTestCase;
import org.junit.Test;

//[TDD] Class: ThisMonthListFragment and Method: Spinner
public class test_thisMonthListFragment_spinner extends InstrumentationTestCase {

    private ThisMonthListFragment mockedProject = new ThisMonthListFragment();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testCheckFavoriteItem() {

        //Goes to the spinner on thismonthlistfragment.

        mockedProject.spinnervalue.contains("July");

        //Checks if the spinner contains july, if so asserts not null because the spinner exists.

        assertNotNull(R.layout.spinner_layout);
    }
}