package com.example.rentbike.domain.model

import android.os.Parcelable
import com.example.rentbike.presentation.model.Address
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BikeStation(
    var number: Int,
    var title: String,
    val distance: Int = 0,
    val address: Address,
    val availableBikes: Int,
    val availableStations: Int
) : Parcelable

@Parcelize
data class Address(
    var street: String,
    var city: String
) : Parcelable