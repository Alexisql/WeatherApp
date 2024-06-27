package com.alexis.weatherapp.ui.detail.adapter

import com.alexis.weatherapp.domain.model.Weather
import com.alexis.weatherapp.ui.util.adapter.BaseDiffUtil

class WeatherDiffUtil(private val oldList: List<Weather>,
                      private val newList: List<Weather>
) : BaseDiffUtil<Weather>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].location.name == newList[newItemPosition].location.name
    }
}