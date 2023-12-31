package com.example.moviesapp.domain.useccase

import com.example.moviesapp.data.model.Movie
import com.example.moviesapp.domain.repository.MovieRepository

class GetMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? {
        return movieRepository.getMovies()
    }
}