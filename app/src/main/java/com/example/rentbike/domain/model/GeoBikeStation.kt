package com.example.rentbike.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GeoBikeStation(
    var number: Int,
    var title: String,
    val distance: Float,
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val availableBikes: Int,
    val availableStations: Int
) : Parcelable

