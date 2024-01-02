package com.example.moviesapp.di

import com.example.moviesapp.data.api.TMDBService
import com.example.moviesapp.data.datasource.MovieRemoteDataSource
import com.example.moviesapp.data.datasourceImpl.MovieRemoteDataSourceImpl
import dagger.Provides
import javax.inject.Singleton

class RemoteDataModule (private val apiKey : String){

    @Singleton
    @Provides
    fun providesRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}