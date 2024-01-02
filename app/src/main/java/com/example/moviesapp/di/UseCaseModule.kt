package com.example.moviesapp.di

import com.example.moviesapp.domain.repository.MovieRepository
import com.example.moviesapp.domain.useccase.GetMovieUseCase
import com.example.moviesapp.domain.useccase.UpdateMovieUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovideUseCase(movieRepository: MovieRepository) : GetMovieUseCase {
        return GetMovieUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMovieUseCase {
        return UpdateMovieUseCase(movieRepository)
    }
}