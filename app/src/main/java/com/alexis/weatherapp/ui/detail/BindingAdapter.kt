package com.alexis.weatherapp.ui.detail

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alexis.weatherapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

@BindingAdapter("setImage")
fun setImage(view: ImageView, path: String) {
    Glide
        .with(view.context)
        .load(path)
        .error(R.drawable.ic_not_found)
        .transform(MultiTransformation(CenterInside(), RoundedCorners(1)))
        .into(view)
}