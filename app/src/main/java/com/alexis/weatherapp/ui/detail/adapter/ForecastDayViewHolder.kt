package com.alexis.weatherapp.ui.detail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alexis.weatherapp.databinding.ItemWeatherDayBinding
import com.alexis.weatherapp.domain.model.ForecastDay

class ForecastDayViewHolder(view: View) : ViewHolder(view) {

    private val binding = ItemWeatherDayBinding.bind(view)

    fun setView(forecastDay: ForecastDay) {
        binding.apply {
            this.forecastDay = forecastDay
        }
    }
}