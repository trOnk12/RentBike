package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.LocationProvider
import com.example.rentbike.domain.model.Location
import io.reactivex.Observable
import javax.inject.Inject

class GetCurrentLocation
@Inject constructor(private val locationProvider: LocationProvider) {

    fun get(): Observable<Location> =
        locationProvider.getLocation()

}