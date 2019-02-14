/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.GenericDAO;
import dao.MovieDAOImpl;
import java.util.ArrayList;
import model.Movie;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


/**
 *
 * @author chreh
 */
public class MovieManagerTest {
    
    public MovieManagerTest() {
    }
    
    MovieDAOImpl dao;
    MovieManager subject;
    Movie m;
    
    
    @Before
    public void setUp() {
        m = new Movie();
        subject = new MovieManager();
        dao = mock(MovieDAOImpl.class);
        subject.setDao(dao);
        Mockito.when(dao.getAllThings()).thenReturn(new ArrayList<Movie>());
        Mockito.when(dao.getOneThing(1L)).thenReturn(new Movie());
    }
    

    @Test
    public void testAddMovie() {
        subject.addMovie(m);
        verify(dao, times(1)).addThing(m);
    }

    @Test
    public void testGetMovie() {
        m = subject.getMovie(1L);
        assertEquals(m, new Movie());
        verify(dao, times(1)).getOneThing(1L);
    }

    @Test
    public void testGetAllMovies() {
        assertEquals(subject.getAllMovies(), new ArrayList<Movie>());
    }

    @Test
    public void testEditMovie() {
        subject.editMovie(m);
        verify(dao, times(1)).editThing(m);
    }

    @Test
    public void testRemoveMovie() {
        subject.removeMovie(1L);
        verify(dao, times(1)).removeThing(1L);
    }

}
