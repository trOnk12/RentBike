package com.example.rentbike.presentation.bikestationlist

import android.location.LocationProvider
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rentbike.core.platform.BaseViewModel
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.domain.usecase.GetBikeStations
import com.example.rentbike.domain.usecase.GetGeoBikeStations
import com.example.rentbike.presentation.model.BikeStationItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BikeStationsViewModel
@Inject constructor(private var geoBikeStations: GetGeoBikeStations) : BaseViewModel() {

    var bikeStations: MutableLiveData<List<GeoBikeStation>> = MutableLiveData()

    fun fetchBikeStations() {
        compositeDisposable.add(
            geoBikeStations.get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ bikeStations.value = it }, { Log.d("TEST", it.message) })
        )
    }

}