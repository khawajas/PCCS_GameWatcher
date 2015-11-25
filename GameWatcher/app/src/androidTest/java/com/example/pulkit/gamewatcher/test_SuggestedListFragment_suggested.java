package com.example.pulkit.gamewatcher;

import android.test.InstrumentationTestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

//[TDD] Class: SuggestedListFragment and Method: Suggested

public class test_SuggestedListFragment_suggested extends InstrumentationTestCase {

    private SuggestedListFragment mockedProject = new SuggestedListFragment();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Before
    public void preTest(){

        //Asserts that the suggested list is not null and is populated or empty, but not null.

        assertNotNull(R.id.list_suggested);
    }

    @Test
    public void testSuggested() {

        //creates the new arraylist inside of the suggestedlistfragment.
        mockedProject.suggested = new ArrayList<>();

        //places a product inside of the newly created arraylist.
        mockedProject.suggested.add(new Product(5, "Star Craft: Legacy Of The Void", "11/20/2015", "PC", 0, "RTS"));
        assertNotNull(mockedProject.suggested);

    }

}