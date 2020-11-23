package com.spring.security.services;

import com.spring.security.DTOs.GetMovieDTO;
import com.spring.security.models.MovieResults;
import com.spring.security.repositories.MovieRepository;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static String BASE_URL = "https://api.themoviedb.org/3/";



    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build();

    public MovieResults getMoviesByCategory(String category, String apiKey, String language, int page) throws IOException {

        MovieAPIService movieAPIService = retrofit.create(MovieAPIService.class);

        Call<MovieResults> call = movieAPIService.listOfMovies(category, apiKey, language, page);

        Response<MovieResults> resultsResponse = call.execute();
        return resultsResponse.body();
    }

    public GetMovieDTO getMovieById(Integer movieId, String apiKey) throws IOException {
        MovieAPIService movieAPIService = retrofit.create(MovieAPIService.class);

        Call<GetMovieDTO> call = movieAPIService.getMovie(movieId, apiKey);

        Response<GetMovieDTO> resultsResponse = call.execute();
        return resultsResponse.body();
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

}
