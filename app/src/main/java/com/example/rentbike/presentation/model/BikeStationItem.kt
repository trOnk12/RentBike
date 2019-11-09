package com.example.rentbike.presentation.model

data class BikeStationItem(
    var number: Int,
    var title: String,
    val distance: Int = 0,
    val address: Address,
    val availableBikes: Int,
    val availableStations: Int
)