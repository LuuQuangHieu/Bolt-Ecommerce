package com.glory.mvvmexample.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["loadImage"])
fun loadImage(view: ImageView, source: String?) {
    source?.let {
        Glide.with(view.context).load(source).into(view)
    }
}

@BindingAdapter(value = ["loadImageInt"])
fun loadImageInt(view: ImageView, source: Int?) {
    source?.let {
        Glide.with(view.context).load(source).into(view)
    }
}

@BindingAdapter(value = ["loadAlphaLayer"])
fun loadAlphaLayer(view: ImageView, source: Int?) {
    source?.let {
        Glide.with(view.context).load(source).into(view)
    }
}

@BindingAdapter(value = ["loadTextInt"])
fun loadTextInt(view: TextView, source: Int?) {
    source?.let {
        view.text = source.toString()
    }
}

@BindingAdapter(value = ["loadText"])
fun loadText(view: TextView, source: String?) {
    source?.let {
        view.text = source.toString()
    }
}

@BindingAdapter(value = ["loadTextPrice"])
fun loadTextPrice(view: TextView, source: Double?) {
    source?.let {
        view.text = "$ " + source.toString()
    }
}



