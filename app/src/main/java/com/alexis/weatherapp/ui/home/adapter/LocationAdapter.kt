package com.alexis.weatherapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.alexis.weatherapp.R
import com.alexis.weatherapp.domain.model.Location
import com.alexis.weatherapp.ui.util.adapter.BaseAdapter

class LocationAdapter(private val onItemClickListener: (String) -> Unit) :
    BaseAdapter<Location, LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_location, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.setView(data[position], onItemClickListener)
    }

    override fun updateList(newList: List<Location>) {
        val locationDiff = LocationDiffUtil(data, newList)
        val result = DiffUtil.calculateDiff(locationDiff)
        data = newList
        result.dispatchUpdatesTo(this)
    }
}