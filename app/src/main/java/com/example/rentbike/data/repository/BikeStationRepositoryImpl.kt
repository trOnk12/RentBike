package com.example.rentbike.data.repository

import com.example.rentbike.data.datasource.BikeStationRemoteSource
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.repository.BikeStationRepository

class BikeStationRepositoryImpl(private val bikeStationRemoteSource: BikeStationRemoteSource) : BikeStationRepository {

    override fun getBikeStations(): List<BikeStation> {
        return bikeStationRemoteSource.get()
    }

}