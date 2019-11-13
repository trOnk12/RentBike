package com.example.rentbike.data.repository

import com.example.rentbike.data.datasource.GeoCodingRemoteSource
import com.example.rentbike.domain.model.Address
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.repository.GeoCodingRepository
import io.reactivex.Observable
import io.reactivex.Single

class GeoCodingRepositoryImpl(private val geoCodingRemoteSource: GeoCodingRemoteSource) : GeoCodingRepository {

    override fun getAddress(latitude: Double, longitude: Double): Observable<List<Address>> {
        return geoCodingRemoteSource.get(latitude, longitude)
    }

}