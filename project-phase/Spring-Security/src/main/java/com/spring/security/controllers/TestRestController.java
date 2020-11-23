package com.spring.security.controllers;

import com.spring.security.DTOs.GetMovieDTO;
import com.spring.security.models.Movie;
import com.spring.security.models.MovieResults;
import com.spring.security.services.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.http.Path;

import java.io.IOException;

@RestController
public class TestRestController {

    private final MovieServiceImpl movieService;

    @Autowired
    public TestRestController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies/{category}")
    public MovieResults getAll(@PathVariable("category") String category,
                               @RequestParam("api_key") String apiKey,
                               @RequestParam("language") String language,
                               @RequestParam("page") int page) throws Exception {

        return movieService.getMoviesByCategory(category, apiKey, language, page);
    }

    @GetMapping("movie/{movie_id}")
    public GetMovieDTO test(@PathVariable("movie_id") Integer movieId,
                            @RequestParam("api_key") String apiKey) throws IOException {

        return movieService.getMovieById(movieId, apiKey);
    }

//    @GetMapping("/testSecuredEndpoint")
//    public String testSecured() {
//        return "Secured GreenFox";
//    }
}
