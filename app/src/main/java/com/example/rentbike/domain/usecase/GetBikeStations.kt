package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.repository.BikeStationRepository
import io.reactivex.Single
import javax.inject.Inject

class GetBikeStations
@Inject constructor(private val bikeStationRepository: BikeStationRepository) {

    fun run(): Single<List<BikeStation>> {
        return bikeStationRepository.getBikeStations()
    }

}