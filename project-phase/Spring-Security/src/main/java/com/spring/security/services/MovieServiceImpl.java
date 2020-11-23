package com.spring.security.services;

import com.spring.security.repositories.MovieRepository;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

@Service
public class MovieServiceImpl {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Object getMovie(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
    }
}
