package com.example.moviesapp.di

import android.app.Application
import com.example.moviesapp.BuildConfig

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