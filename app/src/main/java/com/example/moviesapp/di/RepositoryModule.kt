package com.example.moviesapp.di

import com.example.moviesapp.data.MovieRepositoryImpl
import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieCacheDataSource: MovieCacheDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieRemoteDataSource: MovieRemoteDataSource
    ) : MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource, movieCacheDataSource, movieLocalDataSource)
    }
}