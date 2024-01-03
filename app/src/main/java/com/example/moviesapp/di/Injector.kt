package com.example.moviesapp.di

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
}