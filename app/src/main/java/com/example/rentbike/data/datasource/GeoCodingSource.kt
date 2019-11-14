package com.example.rentbike.data.datasource

import com.example.rentbike.domain.model.Address
import io.reactivex.Observable
import io.reactivex.Single

interface GeoCodingRemoteSource {

    fun get(latitude:Double,longitude:Double): Observable<List<Address>>

}