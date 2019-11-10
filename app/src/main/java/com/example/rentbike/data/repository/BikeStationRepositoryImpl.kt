package com.example.rentbike.data.repository

import com.example.rentbike.data.datasource.BikeStationRemoteSource
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.repository.BikeStationRepository
import io.reactivex.Single

class BikeStationRepositoryImpl(private val bikeStationRemoteSource: BikeStationRemoteSource) : BikeStationRepository {

    override fun getBikeStations(): Single<List<BikeStation>> {
        return bikeStationRemoteSource.get()
    }

}