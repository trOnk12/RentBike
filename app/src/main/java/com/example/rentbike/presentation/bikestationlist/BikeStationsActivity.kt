package com.example.rentbike.presentation.bikestationlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentbike.R
import com.example.rentbike.core.extension.observe
import com.example.rentbike.core.extension.viewModel
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.model.GeoBikeStation
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class BikeStationsActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context): Intent {
            return Intent(context, BikeStationsActivity::class.java)
        }
    }

    @Inject
    lateinit var bikeStationsAdapter: BikeStationsAdapter

    private lateinit var bikeStationsViewModel: BikeStationsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        initializeView()

        bikeStationsViewModel = viewModel(viewModelFactory) {
            observe(bikeStations, ::handleSuccess)
        }

        bikeStationsViewModel.fetchBikeStations()
    }

    private fun initializeView() {
        bikeStationsAdapter.bikeStationClickListener =
            { bikeStationItem -> navigator.openBikeStationsDetails(this, bikeStationItem) }

        with(bike_stations_list) {
            layoutManager = LinearLayoutManager(this@BikeStationsActivity)
            adapter = bikeStationsAdapter
        }
    }

    private fun handleSuccess(list: List<GeoBikeStation>?) {
        list?.let { bikeStations -> bikeStationsAdapter.bikeStations = bikeStations }
    }

}
