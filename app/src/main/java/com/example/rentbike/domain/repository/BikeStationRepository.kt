package com.example.rentbike.domain.repository

import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.presentation.model.BikeStationItem
import io.reactivex.Single

interface BikeStationRepository {

    fun getBikeStations(): Single<List<BikeStation>>

}