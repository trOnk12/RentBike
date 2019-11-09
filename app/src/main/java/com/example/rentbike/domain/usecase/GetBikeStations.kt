package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.repository.BikeStationRepository

class GetBikeStations(private val bikeStationRepository: BikeStationRepository) {

    fun getBikeStations(): List<BikeStation> {
        return bikeStationRepository.getBikeStations()
    }

}