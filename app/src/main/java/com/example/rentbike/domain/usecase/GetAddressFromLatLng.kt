package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.repository.GeoCodingRepository
import javax.inject.Inject

class GetAddressFromLatLng
@Inject constructor(private val geoCodingRepository: GeoCodingRepository) {

    fun get(latitude: Double, longitude: Double) =
        geoCodingRepository.getAddress(latitude, longitude)

}