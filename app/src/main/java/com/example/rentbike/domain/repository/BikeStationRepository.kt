package com.example.rentbike.domain.repository

import com.example.rentbike.domain.model.BikeStation
import io.reactivex.Observable

interface BikeStationRepository {

    fun getBikeStations(): Observable<List<BikeStation>>

}