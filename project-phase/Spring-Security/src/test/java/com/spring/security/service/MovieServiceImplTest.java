package com.spring.security.service;

import com.spring.security.exceptions.MovieAlreadyExistsException;
import com.spring.security.models.Movie;
import com.spring.security.repositories.MovieRepository;
import com.spring.security.services.MovieServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class MovieServiceImplTest {

    Movie movie, movie1;

    //Create a mock for MovieRepository
    @Mock
    MovieRepository movieRepository;

    //Inject the mocks as dependencies into MovieServiceImpl
    @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> list= null;


    @BeforeEach
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.openMocks(this);
        movie = new Movie();
        movie1 = new Movie();
        movie.setTitle("Sabyasachi");
        movie.setStatus("Released");
        list = new ArrayList();
        list.add(movie);
        movie1.setTitle("Sabya");
        movie1.setStatus("Upcoming");
        list.add(movie1);


    }

    @Test
    public void saveMovieTest() throws MovieAlreadyExistsException {
        when(movieRepository.save(any())).thenReturn(movie);
        Movie savedMovie = movieService.saveMovie(movie);
        Assert.assertEquals(movie,savedMovie);
        verify(movieRepository,times(1)).save(movie);
    }


    @Test
    public void getAllMoviesTest() throws Exception {
        movieRepository.save(movie);
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> getlist = movieService.getAllMovies();
        Assert.assertEquals(list, getlist);
        verify(movieRepository,times(1)).findAll();
    }

    @Test
    public void updateMovieTest() throws Exception {
        movieRepository.save(movie);
        when(movieRepository.save(any())).thenReturn(movie);
        Movie updatedMovie = movieService.saveMovie(movie);
        Assert.assertEquals(movie,updatedMovie);
    }

    @Test
    public void deleteMovieTest() throws  Exception {
        movieRepository.delete(movie);
        boolean deletedMovie = movieRepository.existsById(2);
        Assert.assertEquals(false,deletedMovie);
    }
}
