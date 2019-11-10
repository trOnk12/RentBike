package com.example.rentbike.presentation.bikestationlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rentbike.core.platform.BaseViewModel
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.usecase.GetBikeStations
import com.example.rentbike.presentation.model.BikeStationItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BikeStationsViewModel
@Inject constructor(var getBikeStations: GetBikeStations) : BaseViewModel() {

    var bikeStations: MutableLiveData<List<BikeStation>> = MutableLiveData()

    fun fetchBikeStations() {
        compositeDisposable.add(
            getBikeStations.run()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ bikeStations.value = it }, {})
        )
    }

}