/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.MovieDAOImpl;
import java.util.ArrayList;
import model.Movie;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;


/**
 *
 * @author chreh
 */
public class MovieManagerTest {
    
    public MovieManagerTest() {
    }
    
    @Mock
    MovieDAOImpl dao;
    @InjectMocks
    MovieManager subject;
    
    Movie m;
    
    
    @Before
    public void setUp() {
        m = new Movie("Test", "Testing Actor", 100);
        subject = new MovieManager();
//        dao = mock(MovieDAOImpl.class);
//        subject.setDao(dao);
        MockitoAnnotations.initMocks(this);
        Mockito.when(dao.getAllThings()).thenReturn(new ArrayList<Movie>());
        Mockito.when(dao.getOneThing(1L)).thenReturn(m);
    }
    

    @Test
    public void testAddMovie() {
        subject.addMovie(m);
        verify(dao, times(1)).addThing(m);
    }

    @Test
    public void testGetMovie() {
        m = subject.getMovie(1L);
        assertEquals(m, dao.getOneThing(1L));
        verify(dao, times(2)).getOneThing(1L);
    }   

    @Test
    public void testGetAllMovies() {
        assertEquals(subject.getAllMovies(), new ArrayList<Movie>());
        verify(dao, times(1)).getAllThings();
    }

    @Test
    public void testEditMovie() {
        m.setName("Name changed");
        subject.editMovie(m);
        assertNotEquals(subject.getMovie(1L).getName(), "Not the same name");
        verify(dao, times(1)).editThing(m);
    }

    @Test
    public void testRemoveMovie() {
        subject.removeMovie(1L);
        verify(dao, times(1)).removeThing(1L);
    }

}
