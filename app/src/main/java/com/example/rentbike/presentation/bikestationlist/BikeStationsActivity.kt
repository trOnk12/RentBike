package com.example.rentbike.presentation.bikestationlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentbike.R
import com.example.rentbike.core.Navigator
import com.example.rentbike.core.extension.observe
import com.example.rentbike.core.extension.viewModel
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.presentation.model.BikeStationItem
import javax.inject.Inject

class BikeStationsActivity : BaseActivity() {

    @Inject
    lateinit var bikeStationsAdapter: BikeStationsAdapter
    lateinit var bikeStationsViewModel: BikeStationsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setContentView(R.layout.activity_main)

        bikeStationsAdapter.bikeStationClickListener =
            { bikeStationItem -> navigator.openBikeStationsDetails(this, bikeStationItem) }

        bikeStationsViewModel = viewModel(viewModelFactory) {
            observe(bikeStations, ::handleSuccess)
        }
    }

    private fun handleFailure(list: List<BikeStationItem>?) {

    }

    private fun handleSuccess(list: List<BikeStationItem>?) {
        list?.let { bikeStations -> bikeStationsAdapter.bikeStations = bikeStations }
    }
}
