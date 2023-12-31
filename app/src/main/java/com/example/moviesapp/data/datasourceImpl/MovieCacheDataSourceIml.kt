package com.example.moviesapp.data.datasourceImpl

import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.model.Movie

class MovieCacheDataSourceIml : MovieCacheDataSource {
    var moviesList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}