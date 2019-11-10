package com.example.rentbike.core.di.modules

import com.example.rentbike.data.datasource.BikeStationRemoteSource
import com.example.rentbike.data.repository.BikeStationRepositoryImpl
import com.example.rentbike.datasource.BikeStationApi
import com.example.rentbike.datasource.BikeStationRemoteSourceImpl
import com.example.rentbike.domain.repository.BikeStationRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBikeStationApi(retrofit: Retrofit): BikeStationApi {
        return retrofit.create(BikeStationApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(bikeStationApi: BikeStationApi): BikeStationRemoteSource {
        return BikeStationRemoteSourceImpl(bikeStationApi)
    }

    @Singleton
    @Provides
    fun provideBikeStationRepository(bikeStationRemoteSource: BikeStationRemoteSource): BikeStationRepository {
        return BikeStationRepositoryImpl(bikeStationRemoteSource)
    }

}