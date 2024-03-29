package com.example.rentbike.domain.usecase

import com.example.rentbike.domain.model.Address
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.domain.model.Location
import com.example.rentbike.domain.model.parseToGeoBikeStation
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class GetGeoBikeStations
@Inject constructor(
    private val getBikeStations: GetBikeStations,
    private val getAddressFromLatLng: GetAddressFromLatLng,
    private val getDistanceFromCurrentLocation: GetDistanceFromCurrentLocation
) {

    fun get(): Single<List<GeoBikeStation>> {
        return getBikeStations.get()
            .toObservable()
            .flatMap { list ->
                Observable.fromIterable(list)
                    .flatMap { item ->
                        Observable.zip(
                            getAddressFromLatLng.get(item.latitude, item.longitude),
                            getDistanceFromCurrentLocation.get(Location(item.latitude, item.longitude)),
                            BiFunction<List<Address>, Float, GeoBikeStation> { address, distance ->
                                item.parseToGeoBikeStation(address[0], distance)
                            }
                        )
                    }
            }.toList()
    }

}