package com.example.pulkit.gamewatcher;

import android.test.InstrumentationTestCase;
import com.example.pulkit.gamewatcher.Product;
import org.junit.Test;

//[TDD] Class: Product and Method: Product

public class test_Product_Product extends InstrumentationTestCase {
    private int mGame = 0;
    private String mName = "Bloodborne: The Old Hunters";
    private String mDate = "02/03/2015";
    private String mPlatform = "PS4";
    private int mRating = 0;
    private String mGenre = "RPG";
    private Product mockedProject = new Product(mGame, mName, mDate, mPlatform, mRating, mGenre);


    //checks to see if you can populate the arraylist Product in Product

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals(mGame, mockedProject.getId());
    }

    @Test
    public void testSetId() throws Exception {
        int str = 0;
        mockedProject.setId(str);
        assertEquals(str, mockedProject.getId());
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals(mName, mockedProject.getGame());
    }

    @Test
    public void testSetName() throws Exception {
        String str = "Bloodborne: The Old Hunters";
        mockedProject.setGame(str);
        assertEquals(str, mockedProject.getGame());
    }

    @Test
    public void testGetDate() throws Exception {
        assertEquals(mDate, mockedProject.getReleaseDate());
    }

    @Test
    public void testSetDate() throws Exception {
        String str = "02/03/2015";
        mockedProject.setReleaseDate(str);
        assertEquals(str, mockedProject.getReleaseDate());
    }

    @Test
    public void testGetPlatform() throws Exception {
        assertEquals(mPlatform, mockedProject.getPlatform());
    }

    @Test
    public void testSetPlatform() throws Exception {
        String str = "PS4";
        mockedProject.setPlatform(str);
        assertEquals(str, mockedProject.getPlatform());
    }

    @Test
    public void testGetRating() throws Exception {
        assertEquals(mRating, mockedProject.getRating());
    }

    @Test
    public void testSetRating() throws Exception {
        int str = 0;
        mockedProject.setRating(str);
        assertEquals(str, mockedProject.getRating());
    }

    @Test
    public void testGetGenre() throws Exception {
        assertEquals(mGenre, mockedProject.getGenre());
    }

    @Test
    public void testSetGenre() throws Exception {
        String str = "RPG";
        mockedProject.setGenre(str);
        assertEquals(str, mockedProject.getGenre());
    }
}