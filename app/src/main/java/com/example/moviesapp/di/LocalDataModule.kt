package com.example.moviesapp.di

import com.example.moviesapp.data.datasource.MovieLocalDataSource
import com.example.moviesapp.data.datasourceImpl.MovieLocalDataSourceImpl
import com.example.moviesapp.data.db.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
}