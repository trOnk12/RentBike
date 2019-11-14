package com.example.rentbike.presentation.bikestationlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rentbike.R
import com.example.rentbike.core.extension.observe
import com.example.rentbike.core.extension.viewModel
import com.example.rentbike.core.functional.Resource
import com.example.rentbike.core.functional.ResourceState
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
            observe(bikeStations, ::updateBikeStations)
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

    private fun updateBikeStations(resource: Resource<List<GeoBikeStation>>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> startRefreshing()
                ResourceState.SUCCESS -> stopRefreshing()
                ResourceState.ERROR -> stopRefreshing()
            }
            it.data?.let { bikeStationsAdapter.bikeStations = it }
            it.message?.let { Log.d("TEST",it) }
        }
    }

    private fun stopRefreshing() {
        bike_stations_list.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
    }

    private fun startRefreshing() {
        bike_stations_list.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE
    }

}
