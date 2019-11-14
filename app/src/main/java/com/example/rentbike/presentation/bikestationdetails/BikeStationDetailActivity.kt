package com.example.rentbike.presentation.bikestationdetails

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.rentbike.R
import com.example.rentbike.core.extension.askPermission
import com.example.rentbike.core.extension.isHasPermission
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.domain.model.GeoBikeStation
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
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

    private val ZOOM_LEVEL = 13f

    private val geoBikeStation: GeoBikeStation by lazy {
        intent.getParcelableExtra(INTENT_EXTRA_PARAM_BIKE_STATION) as GeoBikeStation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bike_station_detail_activity)

        initializeView()
    }

    private fun initializeView() {
        bike_station_view.setBikeStationModel(geoBikeStation)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return
        with(googleMap) {
            val geoBikeMarker = LatLng(geoBikeStation.latitude, geoBikeStation.longitude)
            moveCamera(
                CameraUpdateFactory.newLatLngZoom(
                    geoBikeMarker,
                    ZOOM_LEVEL
                )
            )
            if (ContextCompat.checkSelfPermission(
                    this@BikeStationDetailActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                isMyLocationEnabled = true
                uiSettings.isMyLocationButtonEnabled = true
            }

            addMarker(MarkerOptions().position(geoBikeMarker))
        }
    }

}