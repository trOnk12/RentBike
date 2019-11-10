package  com.example.rentbike.datasource.model

import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.presentation.model.Address
import com.google.gson.annotations.SerializedName

data class BikeStationEntity(
    @SerializedName("features") val features: List<Features>,
    @SerializedName("crs") val crs: Crs,
    @SerializedName("type") val type: String
)

fun BikeStationEntity.mapToDomain(): List<BikeStation> {
    return features.map {
        BikeStation(
            it.id,
            it.properties.label,
            0,
            Address("Kraków", "Test"),
            it.properties.bikes,
            it.properties.freeRacks
        )
    }
}