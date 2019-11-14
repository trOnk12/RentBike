package com.example.rentbike.data.datasource

import com.example.rentbike.domain.model.Address
import io.reactivex.Observable

interface GeoCodingRemoteSource {

    fun get(latitude:Double,longitude:Double): Observable<List<Address>>

}