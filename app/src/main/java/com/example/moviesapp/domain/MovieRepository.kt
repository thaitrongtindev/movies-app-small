package com.example.moviesapp.domain

import com.example.moviesapp.data.model.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}