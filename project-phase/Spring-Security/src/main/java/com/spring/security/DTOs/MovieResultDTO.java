package com.spring.security.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class MovieResultDTO {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("total_results")
    private Integer total_results;
    @JsonProperty("total_pages")
    private Integer total_pages;
    @JsonProperty("results")
    private List<MovieResultDTO.ResultsDTO> results;

    @NoArgsConstructor
    @Data
    public static class ResultsDTO {

        @JsonProperty("popularity")
        private Double popularity;
        @JsonProperty("vote_count")
        private Integer vote_count;
        @JsonProperty("video")
        private Boolean video;
        @JsonProperty("poster_path")
        private String poster_path;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("adult")
        private Boolean adult;
        @JsonProperty("backdrop_path")
        private String backdrop_path;
        @JsonProperty("original_language")
        private String original_language;
        @JsonProperty("original_title")
        private String original_title;
        @JsonProperty("title")
        private String title;
        @JsonProperty("vote_average")
        private Double vote_average;
        @JsonProperty("overview")
        private String overview;
        @JsonProperty("release_date")
        private String release_date;
        @JsonProperty("genre_ids")
        private List<Integer> genre_ids;
    }
}
