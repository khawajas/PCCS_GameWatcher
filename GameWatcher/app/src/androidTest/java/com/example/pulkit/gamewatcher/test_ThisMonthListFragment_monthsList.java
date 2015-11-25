package com.example.pulkit.gamewatcher;

import android.app.Activity;
import android.content.Context;
import android.test.InstrumentationTestCase;
import android.widget.ListView;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

//[TDD] Class: ThisMonthListFragment and Method: Months

public class test_ThisMonthListFragment_monthsList extends InstrumentationTestCase {

    private ThisMonthListFragment mockedProject = new ThisMonthListFragment();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Before
    public void preTest(){

        //Asserts that the this month list is not null and is populated or empty, but not null.

        assertNotNull(R.id.list_thismonth);
    }

    @Test
    public void testMonths() {

        //creates the new arraylist inside of the thismonthlistfragment.
        mockedProject.months = new ArrayList<>();

        //places a product inside of the newly created arraylist.
        mockedProject.months.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
        assertNotNull(mockedProject.months);

    }

}