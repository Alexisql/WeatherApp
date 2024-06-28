package com.alexis.weatherapp.ui.home.adapter

import com.alexis.weatherapp.domain.model.Location
import com.alexis.weatherapp.ui.util.adapter.BaseDiffUtil

class LocationDiffUtil(
    private val oldList: List<Location>,
    private val newList: List<Location>
) : BaseDiffUtil<Location>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}