package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.data.db.MovieDao
import com.example.moviesapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesMovieDatabase(context : Context) : TMDBDatabase {
        return Room.databaseBuilder(
            context,TMDBDatabase::class.java,
            "tmdbclient"
        ).build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }
}