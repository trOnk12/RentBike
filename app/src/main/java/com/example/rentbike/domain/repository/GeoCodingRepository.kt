package com.example.rentbike.domain.repository

import com.example.rentbike.domain.model.Address
import io.reactivex.Observable
import io.reactivex.Single

interface GeoCodingRepository {

    fun getAddress(latitude: Double, longitude: Double): Observable<List<Address>>

}