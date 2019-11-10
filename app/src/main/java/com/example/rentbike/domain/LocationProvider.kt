package com.example.rentbike.domain

import com.example.rentbike.domain.model.Location
import io.reactivex.Observable
import io.reactivex.Single

interface LocationProvider {
    fun getLocation(): Single<Location>
    fun getDistance(destinyLocation: Location): Observable<Float>
}