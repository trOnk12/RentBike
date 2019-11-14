package com.example.rentbike.presentation.bikestationlist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rentbike.R
import com.example.rentbike.core.extension.startRefreshing
import com.example.rentbike.core.extension.stopRefreshing
import com.example.rentbike.core.functional.Resource
import com.example.rentbike.core.functional.ResourceState
import com.example.rentbike.core.platform.BaseActivity
import com.example.rentbike.domain.model.GeoBikeStation
import kotlinx.android.synthetic.main.bike_stations_list_activity.*
import javax.inject.Inject

class BikeStationsActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context): Intent {
            return Intent(context, BikeStationsActivity::class.java)
        }
    }

    @Inject
    lateinit var bikeStationsAdapter: BikeStationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bike_stations_list_activity)
        appComponent.inject(this)
        initializeView()

        val vm =
            ViewModelProviders.of(this, viewModelFactory)[BikeStationsViewModel::class.java]

        if (savedInstanceState == null) {
            vm.fetchBikeStations()
        }

        vm.bikeStations.observe(this, Observer(::updateBikeStations))
        swipeRefreshLayout.setOnRefreshListener { vm.fetchBikeStations() }
    }

    private fun initializeView() {
        bikeStationsAdapter.bikeStationClickListener =
            { bikeStationItem -> navigator.openBikeStationsDetails(this, bikeStationItem) }

        bikeStationsList.adapter = bikeStationsAdapter
    }

    private fun updateBikeStations(resource: Resource<List<GeoBikeStation>>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> swipeRefreshLayout.startRefreshing()
                ResourceState.SUCCESS, ResourceState.ERROR -> swipeRefreshLayout.stopRefreshing()
            }
            it.data?.let { data -> bikeStationsAdapter.bikeStations = data }
            it.message?.let { message -> showToast(message) }
        }
    }

}
