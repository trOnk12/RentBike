package com.example.rentbike.presentation.bikestationlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rentbike.R
import com.example.rentbike.core.Navigator
import com.example.rentbike.core.extension.observe
import com.example.rentbike.core.extension.viewModel
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.presentation.model.BikeStationItem
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class BikeStationsActivity : BaseActivity() {

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

    private fun handleSuccess(list: List<BikeStation>?) {
        list?.let { bikeStations -> bikeStationsAdapter.bikeStations = bikeStations }
    }

}
