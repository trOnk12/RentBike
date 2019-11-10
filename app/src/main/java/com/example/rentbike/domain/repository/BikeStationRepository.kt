package com.example.rentbike.domain.repository

import com.example.rentbike.domain.model.BikeStation
import io.reactivex.Observable
import io.reactivex.Single

interface BikeStationRepository {

    fun getBikeStations(): Observable<List<BikeStation>>

}