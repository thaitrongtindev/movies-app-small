package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.di.AppCompoent
import com.example.moviesapp.di.AppModule
import com.example.moviesapp.di.DaggerAppCompoent
import com.example.moviesapp.di.Injector
import com.example.moviesapp.di.MovieSubComponent
import com.example.moviesapp.di.NetModule
import com.example.moviesapp.di.RemoteDataModule

class App : Application(), Injector {
    private lateinit var appComponent : AppCompoent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppCompoent.builder().
                appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL)).
                remoteDataModule(RemoteDataModule(BuildConfig.API_KEY)).build()
    }
    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}