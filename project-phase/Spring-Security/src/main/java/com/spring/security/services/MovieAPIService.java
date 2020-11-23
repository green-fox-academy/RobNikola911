package com.spring.security.services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieAPIService {

    @GET("/movie/{movie_id}")
    Call<Object> movie();
}
