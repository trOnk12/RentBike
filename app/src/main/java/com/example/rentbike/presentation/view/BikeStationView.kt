package com.example.rentbike.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.rentbike.databinding.BikeStationInfoBinding
import com.example.rentbike.domain.model.GeoBikeStation

class BikeStationView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var bikeStationViewBinding: BikeStationInfoBinding

    init {
        val inflater = LayoutInflater.from(context)
        bikeStationViewBinding = BikeStationInfoBinding.inflate(inflater,this,true)
    }

    fun setBikeStationModel(geoBikeStation: GeoBikeStation) {
        bikeStationViewBinding.geoBikeStation = geoBikeStation
        bikeStationViewBinding.executePendingBindings()
    }

}