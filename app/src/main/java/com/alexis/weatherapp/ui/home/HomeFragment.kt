package com.alexis.weatherapp.ui.home

import androidx.appcompat.widget.SearchView
import com.alexis.weatherapp.R
import com.alexis.weatherapp.databinding.FragmentHomeBinding
import com.alexis.weatherapp.ui.util.fragment.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun initUI() {
        initListener()
    }

    private fun initListener() {
        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

}