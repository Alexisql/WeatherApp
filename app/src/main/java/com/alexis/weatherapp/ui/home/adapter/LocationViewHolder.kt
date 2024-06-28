package com.alexis.weatherapp.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alexis.weatherapp.databinding.ItemLocationBinding
import com.alexis.weatherapp.domain.model.Location

class LocationViewHolder(view: View) : ViewHolder(view) {

    private val binding = ItemLocationBinding.bind(view)

    fun setView(location: Location, onItemClickSelected: (String) -> Unit) {
        binding.apply {
            this.location = location
            cvItemLocation.setOnClickListener {
                onItemClickSelected(location.name)
            }
        }
    }
}