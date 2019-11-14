package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.repository.BikeStationRepository
import javax.inject.Inject

class GetBikeStations
@Inject constructor(
    private val bikeStationRepository: BikeStationRepository
) {

    fun get() =
        bikeStationRepository.getBikeStations()

}