package com.example.rentbike.core.di.modules

import android.content.Context
import com.example.rentbike.AndroidApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application : AndroidApplication) {

    @Provides
    @Singleton
    fun provideApplicationContext() : Context = application

}