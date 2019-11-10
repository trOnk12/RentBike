package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.repository.BikeStationRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBikeStations
@Inject constructor(
    private val bikeStationRepository: BikeStationRepository
) {

    fun get(): Observable<List<BikeStation>> {
        return bikeStationRepository.getBikeStations()
    }

}