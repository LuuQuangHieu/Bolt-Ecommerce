package com.glory.mvvmexample.ui.detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.glory.mvvmexample.R

class ImageSlideAdapter(var list: List<Int>) : PagerAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view: View = LayoutInflater.from(container.context)
            .inflate(R.layout.image_slide_layout, container, false)
        var imageSlide: ImageView = view.findViewById(R.id.iv_imageSlide)
        imageSlide.setImageResource(list.get(position))
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}