package com.example.moviesapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
//Annotation này chỉ định rằng module này sẽ sử dụng MovieSubComponent
// như là một Subcomponent để cung cấp dependencies.
class AppModule (private val context: Context){
    @Singleton
    @Provides
    fun providesApplicationContext() : Context {
        return context.applicationContext
    }
}