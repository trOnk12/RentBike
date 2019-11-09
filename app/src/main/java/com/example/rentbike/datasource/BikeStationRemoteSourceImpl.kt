package com.example.rentbike.datasource

import com.example.rentbike.data.datasource.BikeStationRemoteSource
import com.example.rentbike.domain.model.BikeStation

class BikeStationRemoteSourceImpl(private val bikeStationApi: BikeStationApi) : BikeStationRemoteSource {

    override fun get(): List<BikeStation> {
        return bikeStationApi.getBikeStations()
            .map { it.mapToDomain() }

    }

}