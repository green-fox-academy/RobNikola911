package com.spring.security.services;

import com.spring.security.DTOs.MovieDTO;
import com.spring.security.DTOs.MovieResultDTO;
import com.spring.security.exceptions.NotFoundException;
import com.spring.security.mappings.MovieMapper;
import com.spring.security.models.Movie;
import com.spring.security.repositories.MovieRepository;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl {

    private MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    MovieAPIService movieAPIService;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public static String BASE_URL = "https://api.themoviedb.org/3/";



    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

    public List<Movie> getMoviesByCategory(String category, String apiKey, String language, int page) throws IOException {

        MovieAPIService movieAPIService = retrofit.create(MovieAPIService.class);

        Call<MovieResultDTO> call = movieAPIService.listOfMovies(category, apiKey, language, page);

        Response<MovieResultDTO> resultsResponse = call.execute();

        Movie movie = new Movie();
        if (resultsResponse.body() == null){
            throw new NotFoundException.LinkNotFoundException();
        }
        List<MovieResultDTO.ResultsDTO> resultList = movie.getMovies(resultsResponse.body());
        List<Movie> movieList = resultList.stream().map(movieMapper::map)
                .collect(Collectors.toList());

        for (Movie movie1: movieList) {
            Boolean movieExists = movieRepository.existsByTitle(movie1.getTitle());
            if(resultsResponse.isSuccessful() && !movieExists) {
                movieRepository.save(movie1);
            }
        }

        return movieList;

    }

    public Movie getMovieById(Integer movieId, String apiKey) throws IOException {
        MovieAPIService movieAPIService = retrofit.create(MovieAPIService.class);

        Call<MovieDTO> call = movieAPIService.getMovie(movieId, apiKey);

        Response<MovieDTO> resultsResponse = call.execute();
        if (resultsResponse.body() == null){
            throw new NotFoundException.LinkNotFoundException();
        }
        Movie movie = new Movie(resultsResponse.body());

        boolean movieExist = movieRepository.existsById(movieId);

        if (resultsResponse.isSuccessful() && !movieExist) {
                movieRepository.save(movie);
        }
        return movie;
    }
}

/*    public GetMovieDTO getMovie(Integer movieId , String apiKey) throws IOException {
        MovieAPIService movieAPIService = retrofit.create(MovieAPIService.class);

        Call<GetMovieDTO> call = movieAPIService.getMovie(movieId,apiKey);

        Response<GetMovieDTO> resultsResponse = call.execute();
        return resultsResponse.body();
    }*/

//    @Override
//    public Call<Object> getMovie(Integer movieId) {
//        return null;
//    }

/*    @Override
    public Call<MovieResults> listOfMovies(String category, String apiKey, String language, int page) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieAPIService myInterface = retrofit.create(MovieAPIService.class);

        Call<MovieResults> call = myInterface.listOfMovies(CATEGORY, API_KEY, LANGUAGE, PAGE);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
                assert results != null;
                List<MovieResults.ResultsDTO> listOfMovies = results.getResults();
            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return listOfMovies(category, apiKey, language, page);
    }*/


