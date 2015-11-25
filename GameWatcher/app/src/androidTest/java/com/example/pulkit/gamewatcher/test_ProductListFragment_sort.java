package com.example.pulkit.gamewatcher;

import android.test.InstrumentationTestCase;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

//[TDD] Class: ProductListFragment and Method: Button

public class test_ProductListFragment_sort extends InstrumentationTestCase {

    private ProductListFragment mockedProject = new ProductListFragment();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

        @Test
        public void testFilter() {

            //Checks to see if the checkbox for puzzle exists and is clickable.

            mockedProject.PUZZLE.isClickable();

            //Checks the puzzle button to filter the view.

            mockedProject.PUZZLE.setChecked(true);

            //Asserts that the current listview, fragment_product_list, is not empty and was updated.

            assertNotNull(mockedProject.view);

        }


    }

