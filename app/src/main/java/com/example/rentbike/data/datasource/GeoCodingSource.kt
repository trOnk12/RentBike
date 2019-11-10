package com.example.rentbike.data.datasource

import com.example.rentbike.domain.model.Address
import io.reactivex.Observable

interface GeoCodingRemoteSource {

    fun get(): Observable<List<Address>>

}