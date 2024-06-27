package com.alexis.weatherapp.ui.util.adapter

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtil<DATA>(
    private val oldList: List<DATA>,
    private val newList: List<DATA>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    abstract override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}