package com.example.rentbike.presentation.bikestationdetails

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.rentbike.R
import com.example.rentbike.core.extension.enableCurrentLocation
import com.example.rentbike.core.extension.isHasPermission
import com.example.rentbike.core.extension.moveToMarker
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.domain.model.GeoBikeStation
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.bike_station_detail_activity.*

class BikeStationDetailActivity : BaseActivity(), OnMapReadyCallback {
    companion object {
        private const val INTENT_EXTRA_PARAM_BIKE_STATION = "INTENT_PARAM_BIKE_STATION"

        fun callingIntent(context: Context, bikeStation: GeoBikeStation): Intent {
            val intent = Intent(context, BikeStationDetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_PARAM_BIKE_STATION, bikeStation)
            return intent
        }
    }

    private val geoBikeStation by lazy {
        intent.getParcelableExtra(INTENT_EXTRA_PARAM_BIKE_STATION) as GeoBikeStation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setContentView(R.layout.bike_station_detail_activity)

        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bikeStationView.setBikeStationModel(geoBikeStation)
        mapFragment.getMapAsync(this)
    }

    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return
        with(googleMap) {
            if (isHasPermission(Manifest.permission.ACCESS_COARSE_LOCATION))
                enableCurrentLocation()

            moveToMarker(geoBikeStation.latitude, geoBikeStation.longitude)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}