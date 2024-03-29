package  com.example.rentbike.datasource.model.bikestation

import com.example.rentbike.domain.model.BikeStation
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
            it.geometry.coordinates[1],
            it.geometry.coordinates[0],
            it.properties.bikeRacks,
            it.properties.freeRacks
        )
    }
}