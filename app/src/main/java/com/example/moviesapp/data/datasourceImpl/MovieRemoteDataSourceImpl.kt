package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.model.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource{
    // class connect to TMDBService
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getMoviesPopular(apiKey)

}
