package com.example.rentbike.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BikeStationItem(
    var number: Int,
    var title: String,
    val distance: Int = 0,
    val address: Address,
    val availableBikes: Int,
    val availableStations: Int
) : Parcelable