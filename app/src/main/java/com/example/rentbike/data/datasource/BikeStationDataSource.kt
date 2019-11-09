package com.example.rentbike.data.datasource

import com.example.rentbike.domain.model.BikeStation

interface BikeStationRemoteSource {

    fun get(): List<BikeStation>

}