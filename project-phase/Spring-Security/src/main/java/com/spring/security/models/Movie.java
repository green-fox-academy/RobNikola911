package com.spring.security.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.security.DTOs.MovieDTO;
import com.spring.security.DTOs.MovieResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long myId;
    private Integer id;
    private String title;
    private String status;
    private Double vote_average;
    private Double popularity;

    public Movie(MovieDTO movieDTO) {
        this.id = movieDTO.getId();
        this.title = movieDTO.getTitle();
        this.status = movieDTO.getStatus();
        this.vote_average = movieDTO.getVoteAverage();
        this.popularity = movieDTO.getPopularity();
    }

    public List<MovieResultDTO.ResultsDTO> getMovies(MovieResultDTO movieResultDTO) {
        var list = movieResultDTO.getResults();
        List<MovieResultDTO.ResultsDTO> movieList = new ArrayList<>();
        for (MovieResultDTO.ResultsDTO result : list) {
            this.id = result.getId();
            this.title = result.getTitle();
            this.vote_average = result.getVote_average();
            this.popularity = result.getPopularity();
            movieList.add(result);
        }
        return movieList;
    }

    public Movie(MovieResultDTO.ResultsDTO result) {
        this.id = result.getId();
        this.title = result.getTitle();
        this.vote_average = result.getVote_average();
        this.popularity = result.getPopularity();
    }
}
