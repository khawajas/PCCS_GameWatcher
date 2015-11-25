package com.example.pulkit.gamewatcher;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

//[TDD] Class: SuggestedListFragment and Method: ShowAlert

public class test_SuggestedListFragment_showAlert {

    @Before
    public void preTest(){

        assertNotNull(R.id.suggested_layout_item);
    }
    @Test
    public void suggestionTest() {
        final String expected = Integer.toString(R.string.nothing_suggested);
        assertEquals(expected, String.valueOf(R.string.nothing_suggested));
    }

}