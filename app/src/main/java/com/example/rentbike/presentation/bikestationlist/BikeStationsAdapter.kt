package com.example.rentbike.presentation.bikestationlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rentbike.R
import com.example.rentbike.domain.model.GeoBikeStation
import kotlinx.android.synthetic.main.bike_station_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class BikeStationsAdapter
@Inject constructor() : RecyclerView.Adapter<BikeStationsAdapter.ViewHolder>() {

    var bikeStations: List<GeoBikeStation> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var bikeStationClickListener: (GeoBikeStation) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bikeStationView = inflater.inflate(R.layout.bike_station_item, parent, false)
        return ViewHolder(bikeStationView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(bikeStations[position], bikeStationClickListener)

    override fun getItemCount() = bikeStations.size

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(geoBikeStation: GeoBikeStation, bikeStationClickListener: (GeoBikeStation) -> Unit) {
            with(geoBikeStation) {
                itemView.bike_station_view.setBikeStationModel(this)
                itemView.setOnClickListener { bikeStationClickListener(this) }
            }
        }
    }

}