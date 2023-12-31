package com.example.moviesapp.data

import android.util.Log
import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }


    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMovieFromAPI()

        // get and save thiss here
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromRoom(): List<Movie> {
         lateinit var  movieList: List<Movie>
         try {
             movieList = movieLocalDataSource.getMoviesFromDB()
         } catch (e : Exception) {
             e.printStackTrace()
         }
        if (movieList.size > 0) {
            // get movie from db
            return movieList
        } else {
            // if list = 0 then get dataa from api and save to db
            movieList = getMovieFromAPI()
            movieLocalDataSource.saveMovieToDB(movieList)
        }
        return movieList
    }

    suspend fun getMovieFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            //get dataa from api
            /// retrofit
            val response = movieRemoteDataSource.getMovies()
            Log.e("response", response.toString() )
            // response represent from MovieList
            // in MovieList contain "movie : List<Movie>"
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (e : Exception) {
            e.printStackTrace()
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromRoom()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}