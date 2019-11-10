package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.model.Address
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.domain.model.Location
import com.example.rentbike.domain.model.parseToGeoBikeStation
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class GetGeoBikeStations(
    private val getBikeStations: GetBikeStations,
    private val getAddressFromLatLng: GetAddressFromLatLng,
    private val getDistanceFromCurrentLocation: GetDistanceFromCurrentLocation
) {

    fun get(): Single<MutableList<GeoBikeStation>> {
        return getBikeStations.get()
            .flatMap { list ->
                Observable.fromIterable(list)
                    .flatMap { item ->
                        Observable.zip(
                            getAddressFromLatLng.get(item.latitude, item.longitude),
                            getDistanceFromCurrentLocation.get(Location(item.latitude, item.longitude)),
                            BiFunction<Address, Float, GeoBikeStation> { address, distance ->
                                item.parseToGeoBikeStation(address, distance)
                            }
                        )
                    }
            }
            .toList()
    }

}