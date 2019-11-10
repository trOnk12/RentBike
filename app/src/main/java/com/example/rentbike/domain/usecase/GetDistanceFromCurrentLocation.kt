package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.LocationProvider
import com.example.rentbike.domain.model.Location
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetDistanceFromCurrentLocation
@Inject constructor(var locationProvider: LocationProvider) {

    fun get(destinyLocation: Location) = locationProvider.getDistance(destinyLocation)

}