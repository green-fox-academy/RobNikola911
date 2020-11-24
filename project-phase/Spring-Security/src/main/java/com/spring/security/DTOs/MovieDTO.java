package com.spring.security.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class MovieDTO {

    @JsonProperty("adult")
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("belongs_to_collection")
    @Expose
    private Object belongsToCollection;
    @JsonProperty("budget")
    private Integer budget;
    @JsonProperty("homepage")
    private String homepage;
    @JsonProperty("id")
    private Integer id;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("popularity")
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @JsonProperty("revenue")
    private Integer revenue;
    @JsonProperty("runtime")
    private Integer runtime;
    @JsonProperty("status")
    private String status;
    @JsonProperty("tagline")
    private String tagline;
    @JsonProperty("title")
    private String title;
    @JsonProperty("video")
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @JsonProperty("genres")
    private List<GenresDTO> genres;
    @SerializedName("production_companies")
    @Expose
    private List<ProductionCompaniesDTO> productionCompanies;
    @SerializedName("production_countries")
    @Expose
    private List<ProductionCountriesDTO> productionCountries;
    @SerializedName("spoken_languages")
    @Expose
    private List<SpokenLanguagesDTO> spokenLanguages;

    @NoArgsConstructor
    @Data
    public static class GenresDTO {
        /**
         * id : 18
         * name : Drama
         */

        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class ProductionCompaniesDTO {
        /**
         * id : 2303
         * logo_path : null
         * name : Villealfa Filmproductions
         * origin_country : FI
         */

        @JsonProperty("id")
        private Integer id;
        @SerializedName("logo_path")
        @Expose
        private Object logoPath;
        @JsonProperty("name")
        private String name;
        @SerializedName("origin_country")
        @Expose
        private String originCountry;
    }

    @NoArgsConstructor
    @Data
    public static class ProductionCountriesDTO {

        @SerializedName("iso_3166_1")
        @Expose
        private String iso31661;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class SpokenLanguagesDTO {

        @SerializedName("english_name")
        @Expose
        private String englishName;
        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @JsonProperty("name")
        private String name;
    }
}
