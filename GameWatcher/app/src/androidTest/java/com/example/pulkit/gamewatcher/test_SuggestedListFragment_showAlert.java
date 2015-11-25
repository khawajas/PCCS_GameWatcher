package com.example.pulkit.gamewatcher;


import android.test.InstrumentationTestCase;
import android.test.TouchUtils;
import android.widget.CheckBox;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;


public class test_SuggestedListFragment_showAlert extends InstrumentationTestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    @Before
    public void preTest(){
        assertNull(R.layout.fragment_favorite_list);
    }

    @Test
    public void suggestionTest() {
        final String expected = "Favorite an item to see suggested games!";
        assertEquals(expected, R.string.comeback, R.string.no_suggested_msg);
    }








//    ProductListFragment productListFragment;
//    CheckBox check = (CheckBox) productListFragment.view.findViewById(R.id.checkRPG);
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//    }
//
//    @Test
//    public void testCheck() {
//
//        TouchUtils.clickView(this, check);
//        boolean expected = check.isChecked();
//        assertTrue(expected);
//
//    }
}



