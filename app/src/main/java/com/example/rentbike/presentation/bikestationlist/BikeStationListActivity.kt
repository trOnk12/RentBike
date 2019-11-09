package com.example.rentbike.presentation.bikestationlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentbike.R
import com.example.rentbike.core.platform.BaseActivity
import javax.inject.Inject

class BikeStationListActivity : BaseActivity() {

    @Inject
    lateinit var bikeStationsAdapter: BikeStationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setContentView(R.layout.activity_main)

    }
}
