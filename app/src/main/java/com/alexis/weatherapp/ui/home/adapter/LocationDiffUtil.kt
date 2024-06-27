package com.alexis.weatherapp.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alexis.weatherapp.domain.model.Location

class LocationDiffUtil (private val oldList: List<Location>,
                        private val newList: List<Location>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}