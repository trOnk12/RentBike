package com.example.rentbike.datasource

import com.example.rentbike.datasource.model.bikestation.BikeStationEntity
import com.example.rentbike.datasource.model.google.geocode.GeocodeEntity
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BikeStationApi {

    @GET("mim/plan/map_service.html?mtype=pub_transport&co=stacje_rowerowe")
    fun getBikeStations(): Observable<BikeStationEntity>

}

interface GeoCodingApi {

    //https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=YOUR_API_KEY
    @GET("maps/api/geocode/json?")
    fun getAddress(@Query("latlng") latLng: String, @Query("key") key: String): Observable<GeocodeEntity>

}