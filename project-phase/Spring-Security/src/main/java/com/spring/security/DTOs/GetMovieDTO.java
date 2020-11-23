package com.spring.security.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class GetMovieDTO {

    /**
     * adult : false
     * backdrop_path : /hQ4pYsIbP22TMXOUdSfC2mjWrO0.jpg
     * belongs_to_collection : null
     * budget : 0
     * genres : [{"id":18,"name":"Drama"},{"id":80,"name":"Crime"},{"id":35,"name":"Comedy"}]
     * homepage :
     * id : 2
     * imdb_id : tt0094675
     * original_language : fi
     * original_title : Ariel
     * overview : Taisto Kasurinen is a Finnish coal miner whose father has just committed suicide and who is framed for a crime he did not commit. In jail, he starts to dream about leaving the country and starting a new life. He escapes from prison but things don't go as planned...
     * popularity : 8.967
     * poster_path : /ojDg0PGvs6R9xYFodRct2kdI6wC.jpg
     * production_companies : [{"id":2303,"logo_path":null,"name":"Villealfa Filmproductions","origin_country":"FI"}]
     * production_countries : [{"iso_3166_1":"FI","name":"Finland"}]
     * release_date : 1988-10-21
     * revenue : 0
     * runtime : 73
     * spoken_languages : [{"english_name":"Finnish","iso_639_1":"fi","name":"suomi"},{"english_name":"German","iso_639_1":"de","name":"Deutsch"}]
     * status : Released
     * tagline :
     * title : Ariel
     * video : false
     * vote_average : 6.8
     * vote_count : 118
     */

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
        /**
         * iso_3166_1 : FI
         * name : Finland
         */

        @SerializedName("iso_3166_1")
        @Expose
        private String iso31661;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @Data
    public static class SpokenLanguagesDTO {
        /**
         * english_name : Finnish
         * iso_639_1 : fi
         * name : suomi
         */

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
