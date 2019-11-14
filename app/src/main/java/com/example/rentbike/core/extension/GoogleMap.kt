package com.example.rentbike.core.extension

import android.Manifest
import androidx.annotation.RequiresPermission
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

const val ZOOM_LEVEL = 13f

fun GoogleMap.moveToMarker(latitude: Double, longitude: Double) {
    val latLng = LatLng(latitude,longitude)

    moveCamera(
        CameraUpdateFactory.newLatLngZoom(
            latLng,
            ZOOM_LEVEL
        )
    )
    addMarker(MarkerOptions().position(latLng))
}

@RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
fun GoogleMap.enableCurrentLocation() {
    isMyLocationEnabled = true
    uiSettings.isMyLocationButtonEnabled = true
}