package com.alexis.weatherapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alexis.weatherapp.R
import com.alexis.weatherapp.domain.model.Location

class LocationAdapter(
    private var oldListLocation: List<Location> = listOf(),
    private val onItemClickListener: (String) -> Unit
) : RecyclerView.Adapter<LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_location, parent, false)
        )
    }

    override fun getItemCount(): Int = oldListLocation.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.setView(oldListLocation[position], onItemClickListener)
    }

    fun updateListLocation(newListLocation: List<Location>) {
        val locationDiff = LocationDiffUtil(oldListLocation, newListLocation)
        val result = DiffUtil.calculateDiff(locationDiff)
        oldListLocation = newListLocation
        result.dispatchUpdatesTo(this)
    }
}