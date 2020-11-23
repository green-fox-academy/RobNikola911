package com.spring.security.services;

import com.spring.security.DTOs.GetMovieDTO;
import com.spring.security.models.MovieResults;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPIService {

    @GET("movie/{movie_id}")
    Call<GetMovieDTO> getMovie(
            @Path("movie_id") Integer movieId,
            @Query("api_key") String apiKey);

    @GET("movie/{category}")
    Call<MovieResults> listOfMovies(
            @Path("category") String category,
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );
}
