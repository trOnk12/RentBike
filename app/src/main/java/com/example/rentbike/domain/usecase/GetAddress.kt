package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.model.Address
import com.example.rentbike.domain.repository.GeoCodingRepository
import io.reactivex.Observable
import io.reactivex.Single

class GetAddress(private val geoCodingRepository: GeoCodingRepository) {

    fun get(latitude: Double, longitude: Double): Observable<Address> {
        return geoCodingRepository.getAddress(latitude, longitude)
    }

}