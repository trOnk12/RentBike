package com.example.rentbike.data.repository

import com.example.rentbike.data.datasource.GeoCodingRemoteSource
import com.example.rentbike.domain.model.Address
import com.example.rentbike.domain.repository.GeoCodingRepository
import io.reactivex.Observable

class GeoCodingRepositoryImpl constructor(
    private val geoCodingRemoteSource: GeoCodingRemoteSource)
    : GeoCodingRepository {

    override fun getAddress(latitude: Double, longitude: Double): Observable<List<Address>> =
         geoCodingRemoteSource.get(latitude, longitude)

}