package com.example.rentbike.presentation.bikestationdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.rentbike.R
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.presentation.model.BikeStationItem

class BikeStationDetailActivity : BaseActivity() {
    companion object {
        private const val INTENT_EXTRA_PARAM_BIKE_STATION = "INTENT_PARAM_BIKE_STATION"

        fun callingIntent(context: Context, bikeStationItem: BikeStationItem) {
            val intent = Intent(context, BikeStationDetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_BIKE_STATION, bikeStationItem)
            return
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bike_station_detail_activity)
        appComponent.inject(this)
    }
}