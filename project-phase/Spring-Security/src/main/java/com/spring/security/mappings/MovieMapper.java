package com.spring.security.mappings;

import com.spring.security.DTOs.MovieDTO;
import com.spring.security.models.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie map(MovieDTO movieDTO){

        if (movieDTO == null){
            return null;
        }
        Movie movie = new Movie();

      /*  movie.setId(getMovieDTO.getId());
        movie.setTitle(getMovieDTO.getTitle());
        movie.setStatus(getMovieDTO.getStatus());
        movie.setVote_average(getMovieDTO.getVoteCount());
*/
        return movie;
    }
}