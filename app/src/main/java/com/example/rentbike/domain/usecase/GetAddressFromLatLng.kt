package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.model.Address
import com.example.rentbike.domain.repository.GeoCodingRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetAddressFromLatLng
@Inject constructor(private val geoCodingRepository: GeoCodingRepository) {

    fun get(latitude: Double, longitude: Double) = geoCodingRepository.getAddress(latitude, longitude)

}