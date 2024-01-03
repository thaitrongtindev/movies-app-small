package com.example.moviesapp.di

import com.example.moviesapp.representation.MainActivity
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MainActivity)
    @Subcomponent.Factory
    interface Factory
}