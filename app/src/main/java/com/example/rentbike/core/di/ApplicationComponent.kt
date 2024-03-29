package com.example.rentbike.core.di

import com.example.rentbike.AndroidApplication
import com.example.rentbike.core.di.modules.AppModule
import com.example.rentbike.core.di.modules.NetworkModule
import com.example.rentbike.core.di.modules.RepositoryModule
import com.example.rentbike.core.di.viewmodel.ViewModelModule
import com.example.rentbike.presentation.bikestationdetails.BikeStationDetailActivity
import com.example.rentbike.presentation.bikestationlist.BikeStationsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(bikeStationsActivity: BikeStationsActivity)
    fun inject(bikeStationDetailActivity: BikeStationDetailActivity)
}