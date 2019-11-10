package com.example.rentbike.data.datasource

import com.example.rentbike.domain.model.BikeStation
import io.reactivex.Observable
import io.reactivex.Single

interface BikeStationRemoteSource {

    fun get(): Observable<List<BikeStation>>

}