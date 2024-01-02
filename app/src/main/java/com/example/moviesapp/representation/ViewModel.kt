package com.example.moviesapp.representation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviesapp.domain.useccase.GetMovieUseCase
import com.example.moviesapp.domain.useccase.UpdateMovieUseCase

class ViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
) : ViewModel(){

    fun getMoives()  = liveData {
        val movieList =  getMovieUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMovieUseCase.execute()
            emit(movieList)
    }


}