package com.example.moviesapp.di

import com.example.moviesapp.data.datasource.MovieCacheDataSource
import com.example.moviesapp.data.datasourceImpl.MovieCacheDataSourceIml
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceIml()

    }
}