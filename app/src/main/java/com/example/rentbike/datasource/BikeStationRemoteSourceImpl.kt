package com.example.rentbike.datasource

import com.example.rentbike.data.datasource.BikeStationRemoteSource
import com.example.rentbike.datasource.model.bikestation.mapToDomain
import com.example.rentbike.domain.model.BikeStation
import io.reactivex.Observable
import io.reactivex.Single

class BikeStationRemoteSourceImpl(private val bikeStationApi: BikeStationApi) : BikeStationRemoteSource {

    override fun get(): Observable<List<BikeStation>> {
        return bikeStationApi.getBikeStations()
            .map { it.mapToDomain() }
    }

}