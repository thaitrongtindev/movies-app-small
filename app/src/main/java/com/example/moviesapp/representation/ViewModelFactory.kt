package com.example.moviesapp.representation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.domain.useccase.GetMovieUseCase
import com.example.moviesapp.domain.useccase.UpdateMovieUseCase

class ViewModelFactory(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MyViewModel(getMovieUseCase, updateMovieUseCase) as T
    }

}