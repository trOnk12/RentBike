package com.example.rentbike.datasource

import com.example.rentbike.core.GOOGLE_API_KEY
import com.example.rentbike.data.datasource.GeoCodingRemoteSource
import com.example.rentbike.datasource.model.google.geocode.mapToDomain
import com.example.rentbike.domain.model.Address
import io.reactivex.Observable

class GeoCodingRemoteSourceImpl(private val geoCodingApi: GeoCodingApi) : GeoCodingRemoteSource {

    override fun get(latitude: Double, longitude: Double): Observable<List<Address>> {
        return geoCodingApi.getAddress(latLng = "$latitude,$longitude", key = GOOGLE_API_KEY)
            .map { it.mapToDomain() }
    }

}