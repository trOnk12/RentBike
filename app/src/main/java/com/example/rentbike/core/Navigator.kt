package com.example.rentbike.core

import android.content.Context
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.presentation.bikestationdetails.BikeStationDetailActivity
import com.example.rentbike.presentation.model.BikeStationItem
import javax.inject.Inject

class Navigator @Inject constructor() {

    fun openBikeStationsDetails(context: Context, bikeStation: GeoBikeStation) {
        BikeStationDetailActivity.callingIntent(context, bikeStation)
    }

}