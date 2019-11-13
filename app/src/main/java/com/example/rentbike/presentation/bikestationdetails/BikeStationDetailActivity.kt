package com.example.rentbike.presentation.bikestationdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.rentbike.R
import com.example.rentbike.core.extension.observe
import com.example.rentbike.core.extension.viewModel
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.presentation.model.BikeStationItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.bike_station_detail_activity.*
import java.util.jar.Manifest

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

    private lateinit var bikeStationDetailViewModel: BikeStationDetailViewModel

    private val geoBikeStation: GeoBikeStation by lazy {
        intent.getParcelableExtra(INTENT_EXTRA_PARAM_BIKE_STATION) as GeoBikeStation
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bike_station_detail_activity)
        appComponent.inject(this)

        bike_station_view.setBikeStationModel(geoBikeStation)

        bikeStationDetailViewModel = viewModel(viewModelFactory)


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
            addMarker(MarkerOptions().position(geoBikeMarker))
        }
    }

}