package com.example.rentbike.presentation.bikestationlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rentbike.domain.usecase.GetBikeStations
import com.example.rentbike.presentation.model.BikeStationItem

class BikeStationsViewModel(var getBikeStations: GetBikeStations) : ViewModel() {

    var bikeStations: MutableLiveData<List<BikeStationItem>> = MutableLiveData()

    fun fetchBikeStations() {

    }

}