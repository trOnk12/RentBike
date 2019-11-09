package com.example.rentbike.datasource

import io.reactivex.Single
import retrofit2.http.GET
import BikeStationEntity

interface BikeStationApi {

    @GET("mim/plan/map_service.html?mtype=pub_transport&co=stacje_rowerowe")
    fun getBikeStations(): Single<BikeStationEntity>

}