package com.example.rentbike.data.datasource

import com.example.rentbike.domain.model.BikeStation
import io.reactivex.Single

interface BikeStationRemoteSource {

    fun get(): Single<List<BikeStation>>

}