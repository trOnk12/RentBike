package com.example.rentbike.presentation.bikestationdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.rentbike.R
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.presentation.model.BikeStationItem
import java.util.jar.Manifest

class BikeStationDetailActivity : BaseActivity() {
    companion object {
        private const val INTENT_EXTRA_PARAM_BIKE_STATION = "INTENT_PARAM_BIKE_STATION"

        fun callingIntent(context: Context, bikeStation: GeoBikeStation) {
            val intent = Intent(context, BikeStationDetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_BIKE_STATION, bikeStation)
            return
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bike_station_detail_activity)
        appComponent.inject(this)

    }
}