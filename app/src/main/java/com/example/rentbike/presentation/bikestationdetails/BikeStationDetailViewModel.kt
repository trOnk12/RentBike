package com.example.rentbike.presentation.bikestationdetails

import androidx.lifecycle.MutableLiveData
import com.example.rentbike.core.platform.BaseViewModel
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.domain.model.Location
import com.example.rentbike.domain.usecase.GetCurrentLocation
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BikeStationDetailViewModel
@Inject constructor(private val getCurrentLocation: GetCurrentLocation) : BaseViewModel() {

    val geoBikeStation: MutableLiveData<GeoBikeStation> = MutableLiveData()
    val currentLocation: MutableLiveData<Location> = MutableLiveData()

    fun getCurrentLocation() {
        compositeDisposable.add(
            getCurrentLocation.get()
                .subscribeOn(Schedulers.io())
                .subscribe { currentLocation.value = it }
        )
    }

}