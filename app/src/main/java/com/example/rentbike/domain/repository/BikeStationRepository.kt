package com.example.rentbike.domain.repository

import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.presentation.model.BikeStationItem

interface BikeStationRepository {

    fun getBikeStations(): List<BikeStation>

}