package com.example.rentbike.presentation.bikestationlist

import androidx.lifecycle.MutableLiveData
import com.example.rentbike.core.extension.setError
import com.example.rentbike.core.extension.setLoading
import com.example.rentbike.core.extension.setSuccess
import com.example.rentbike.core.functional.Resource
import com.example.rentbike.core.functional.ResourceState
import com.example.rentbike.core.platform.BaseViewModel
import com.example.rentbike.domain.model.GeoBikeStation
import com.example.rentbike.domain.usecase.GetGeoBikeStations
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BikeStationsViewModel
@Inject constructor(private var geoBikeStations: GetGeoBikeStations) : BaseViewModel() {

    var bikeStations = MutableLiveData<Resource<List<GeoBikeStation>>>()

    fun fetchBikeStations() {
        compositeDisposable.add(
            geoBikeStations.get()
                .doOnSubscribe { bikeStations.setLoading() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ bikeStations.setSuccess(it) }, { bikeStations.setError(it.message) })
        )
    }

}