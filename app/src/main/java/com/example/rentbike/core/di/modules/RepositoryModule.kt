package com.example.rentbike.core.di.modules

import android.content.Context
import com.example.rentbike.data.LocationProviderImpl
import com.example.rentbike.data.datasource.BikeStationRemoteSource
import com.example.rentbike.data.datasource.GeoCodingRemoteSource
import com.example.rentbike.data.repository.BikeStationRepositoryImpl
import com.example.rentbike.data.repository.GeoCodingRepositoryImpl
import com.example.rentbike.datasource.BikeStationApi
import com.example.rentbike.datasource.BikeStationRemoteSourceImpl
import com.example.rentbike.datasource.GeoCodingApi
import com.example.rentbike.datasource.GeoCodingRemoteSourceImpl
import com.example.rentbike.domain.LocationProvider
import com.example.rentbike.domain.repository.BikeStationRepository
import com.example.rentbike.domain.repository.GeoCodingRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBikeStationApi(@Named("bikestation") retrofit: Retrofit): BikeStationApi {
        return retrofit.create(BikeStationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideGeoCodingnApi(@Named("google") retrofit: Retrofit): GeoCodingApi {
        return retrofit.create(GeoCodingApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(bikeStationApi: BikeStationApi): BikeStationRemoteSource {
        return BikeStationRemoteSourceImpl(bikeStationApi)
    }

    @Singleton
    @Provides
    fun provideLocationProvider(context: Context): LocationProvider {
        return LocationProviderImpl(LocationServices.getFusedLocationProviderClient(context))
    }

    @Singleton
    @Provides
    fun provideGeoLocationRemoteSource(geoCodingApi: GeoCodingApi): GeoCodingRemoteSource {
        return GeoCodingRemoteSourceImpl(geoCodingApi)
    }

    @Singleton
    @Provides
    fun provideBikeStationRepository(bikeStationRemoteSource: BikeStationRemoteSource): BikeStationRepository {
        return BikeStationRepositoryImpl(bikeStationRemoteSource)
    }

    @Singleton
    @Provides
    fun provideGeoCodingRepository(geoCodingRemoteSource: GeoCodingRemoteSource): GeoCodingRepository {
        return GeoCodingRepositoryImpl(geoCodingRemoteSource)
    }

}