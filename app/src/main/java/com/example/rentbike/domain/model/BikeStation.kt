package com.example.rentbike.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BikeStation(
    var number: Int,
    var title: String,
    val latitude: Double,
    val longitude: Double,
    val availableBikes: Int,
    val availableStations: Int
) : Parcelable


fun BikeStation.parseToGeoBikeStation(address: Address, distance: Float): GeoBikeStation {
    return GeoBikeStation(
        number,
        title,
        distance,
        latitude,
        longitude,
        address.formattedAddress,
        availableBikes,
        availableStations
    )
}