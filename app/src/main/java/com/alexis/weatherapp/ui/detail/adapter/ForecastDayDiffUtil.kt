package com.alexis.weatherapp.ui.detail.adapter

import com.alexis.weatherapp.domain.model.ForecastDay
import com.alexis.weatherapp.ui.util.adapter.BaseDiffUtil

class ForecastDayDiffUtil(
    private val oldList: List<ForecastDay>,
    private val newList: List<ForecastDay>
) : BaseDiffUtil<ForecastDay>(oldList, newList) {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].date == newList[newItemPosition].date
    }
}