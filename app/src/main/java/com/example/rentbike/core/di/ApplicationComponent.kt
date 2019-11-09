package com.example.rentbike.core.di

import com.example.rentbike.AndroidApplication
import com.example.rentbike.core.di.modules.AppModule
import com.example.rentbike.core.di.modules.NetworkModule
import com.example.rentbike.presentation.bikestationlist.BikeStationListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(bikeStationListActivity: BikeStationListActivity)
}