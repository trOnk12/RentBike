import com.google.gson.annotations.SerializedName

data class BikeStationEntity (
	@SerializedName("features") val features : List<Features>,
	@SerializedName("crs") val crs : Crs,
	@SerializedName("type") val type : String
)

fun BikeStationEntity.mapToDomain(){
	features.map {  }
}