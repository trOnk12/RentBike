package com.example.rentbike.domain.model

import com.example.rentbike.presentation.model.Address

data class BikeStation(
    var number: Int,
    var title: String,
    val distance: Int = 0,
    val address: Address,
    val availableBikes: Int,
    val availableStations: Int
)

data class Address(
    var street: String,
    var city: String
)