package com.example.rentbike.datasource

import com.example.rentbike.datasource.model.BikeStationEntity
import io.reactivex.Single
import retrofit2.http.GET

interface BikeStationApi {

    @GET("mim/plan/map_service.html?mtype=pub_transport&co=stacje_rowerowe")
    fun getBikeStations(): Single<BikeStationEntity>

}