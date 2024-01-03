package com.example.moviesapp.di

import com.example.moviesapp.domain.useccase.GetMovieUseCase
import com.example.moviesapp.domain.useccase.UpdateMovieUseCase
import com.example.moviesapp.representation.ViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun providesMovieViewModelFactory(
        getMovieUseCase: GetMovieUseCase,
        updateMovieUseCase: UpdateMovieUseCase
    ) : ViewModelFactory {
        return ViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }
}