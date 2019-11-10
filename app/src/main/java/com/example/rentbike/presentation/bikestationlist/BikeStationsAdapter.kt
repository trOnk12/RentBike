package com.example.rentbike.presentation.bikestationlist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rentbike.R
import com.example.rentbike.core.extension.inflate
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.presentation.model.BikeStationItem
import kotlinx.android.synthetic.main.bike_station_info.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class BikeStationsAdapter
@Inject constructor() : RecyclerView.Adapter<BikeStationsAdapter.ViewHolder>() {

    var bikeStations: List<BikeStation> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var bikeStationClickListener: (BikeStation) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.bike_station_info))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(bikeStations[position], bikeStationClickListener)

    override fun getItemCount() = bikeStations.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bikeStationItem: BikeStation, bikeStationClickListener: (BikeStation) -> Unit) {
            itemView.station_number.text = bikeStationItem.number.toString()
            itemView.station_title.text = bikeStationItem.title
            itemView.available_bikes.text = bikeStationItem.availableBikes.toString()
            itemView.available_spaces.text = bikeStationItem.availableStations.toString()
            itemView.address.text = bikeStationItem.address.street + "," + bikeStationItem.address.city

            itemView.setOnClickListener { bikeStationClickListener(bikeStationItem) }
        }
    }

}