package com.alexis.weatherapp.ui.util.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseAdapter<DATA, VH : ViewHolder>(
    var data: List<DATA> = listOf()
) : RecyclerView.Adapter<VH>() {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    abstract override fun onBindViewHolder(holder: VH, position: Int)

    abstract fun updateList(newList: List<DATA>)

    override fun getItemCount(): Int = data.size

}