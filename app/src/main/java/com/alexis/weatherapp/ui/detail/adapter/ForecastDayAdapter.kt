package com.alexis.weatherapp.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.alexis.weatherapp.R
import com.alexis.weatherapp.domain.model.ForecastDay
import com.alexis.weatherapp.ui.util.adapter.BaseAdapter

class ForecastDayAdapter : BaseAdapter<ForecastDay, ForecastDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastDayViewHolder {
        return ForecastDayViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather_day, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ForecastDayViewHolder, position: Int) {
        holder.setView(data[position])
    }

    override fun updateList(newList: List<ForecastDay>) {
        val forecastDayDiff = ForecastDayDiffUtil(data, newList)
        val result = DiffUtil.calculateDiff(forecastDayDiff)
        data = newList
        result.dispatchUpdatesTo(this)
    }
}