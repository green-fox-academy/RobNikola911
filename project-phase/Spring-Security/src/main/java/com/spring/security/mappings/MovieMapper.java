package com.spring.security.mappings;

import com.spring.security.DTOs.MovieDTO;
import com.spring.security.DTOs.MovieResultDTO;
import com.spring.security.models.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie map(MovieResultDTO.ResultsDTO result) {

        if (result == null) {
            return null;
        }
        Movie movie = new Movie();

        movie.setId(result.getId());
        movie.setTitle(result.getTitle());
        movie.setPopularity(result.getPopularity());
        movie.setVote_average(result.getVote_average());

        return movie;
    }
}