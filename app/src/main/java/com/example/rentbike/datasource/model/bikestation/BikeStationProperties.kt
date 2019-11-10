package com.example.rentbike.datasource.model.bikestation

import com.google.gson.annotations.SerializedName

data class BikeStationProperties(
    @SerializedName("free_racks") val freeRacks: Int,
    @SerializedName("properties") val bikes: Int,
    @SerializedName("label") val label: String,
    @SerializedName("bike_racks") val bikeRacks: Int,
    @SerializedName("updated") val updated: String
)