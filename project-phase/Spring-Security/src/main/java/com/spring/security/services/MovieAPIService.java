package com.spring.security.services;

import com.spring.security.DTOs.MovieDTO;
import com.spring.security.DTOs.MovieResultDTO;
import com.spring.security.models.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPIService {

    @GET("movie/{movie_id}")
    Call<MovieDTO> getMovie(
            @Path("movie_id") Integer movieId,
            @Query("api_key") String apiKey);

    @GET("movie/{category}")
    Call<MovieResultDTO> listOfMovies(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page);
}
