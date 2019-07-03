package com.group.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testAdd() {
        assertTrue(AddingMovie.add());
    }
    @Test
    public void testDetail() {
        assertTrue(MovieDetails.detail());
    }
    @Test
    public void testMovie() {
        assertTrue(Movie.movie());
    }
    @Test
    public void testApp() {
        assertTrue(App.status());
    }
    @Test
    public void testController() {
        assertTrue(Controller.ifmovie());
    }

}
