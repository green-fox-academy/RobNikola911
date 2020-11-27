package com.spring.security.services;

import com.spring.security.exceptions.MovieAlreadyExistsException;
import com.spring.security.models.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    List<Movie> getMoviesByCategory(String category, String apiKey, String language, int page) throws IOException;

    Movie getMovieById(Integer movieId, String apiKey) throws IOException;

    Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

    List<Movie> getAllMovies();
}
