package com.example.moviesapp.data.api

import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getMoviesPopular(
        @Query("api_key") apiKey: String
    ): Response<MovieList>


}