package com.example.rentbike.presentation.bikestationlist

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rentbike.R
import com.example.rentbike.core.extension.inflate
import com.example.rentbike.domain.model.BikeStation
import com.example.rentbike.domain.model.GeoBikeStation
import kotlinx.android.synthetic.main.bike_station_info.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class BikeStationsAdapter
@Inject constructor() : RecyclerView.Adapter<BikeStationsAdapter.ViewHolder>() {

    var bikeStations: List<GeoBikeStation> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var bikeStationClickListener: (GeoBikeStation) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.bike_station_info))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(bikeStations[position], bikeStationClickListener)

    override fun getItemCount() = bikeStations.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(geoBikeStation: GeoBikeStation, bikeStationClickListener: (GeoBikeStation) -> Unit) {
            with(geoBikeStation){
                itemView.station_number.text = number.toString()
                itemView.station_title.text = title
                if(distance > 1000.00){
                    itemView.current_location_distance.text = (distance / 1000).toString() + "km"
                }
                else{
                    itemView.current_location_distance.text = (distance).toString() + "m"
                }
                itemView.available_bikes.text = availableBikes.toString()
                itemView.available_spaces.text = availableStations.toString()
                itemView.address.text = address.street + "," + geoBikeStation.address.city
                itemView.setOnClickListener { bikeStationClickListener(this) }
            }
        }
    }

}