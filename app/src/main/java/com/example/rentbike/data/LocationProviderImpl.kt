package com.example.rentbike.data

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.rentbike.domain.LocationProvider
import com.example.rentbike.domain.model.Location
import com.google.android.gms.location.FusedLocationProviderClient
import io.reactivex.Single

class LocationProviderImpl(private val fusedLocationProvider: FusedLocationProviderClient) : LocationProvider {

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    override fun getLocation(): Single<Location> {
        return Single.create { emitter ->
            fusedLocationProvider.lastLocation.addOnSuccessListener {
                if (it != null) {
                    emitter.onSuccess(Location(it.latitude, it.longitude))
                } else {
                    emitter.onError(Exception())
                }
            }
        }
    }

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    override fun getDistance(destinyLocation: Location): Single<Float> {
        return getLocation().map {
            calculateDistance(it, destinyLocation)
        }
    }

    private fun calculateDistance(
        currentLocation: Location,
        destinyLocation: Location
    ): Float {
        val results = FloatArray(3)
        android.location.Location.distanceBetween(
            currentLocation.latitude,
            currentLocation.longitude,
            destinyLocation.latitude,
            destinyLocation.longitude,
            results
        )
        return results[0]
    }

}