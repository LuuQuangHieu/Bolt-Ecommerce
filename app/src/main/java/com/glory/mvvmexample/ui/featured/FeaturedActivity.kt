package com.glory.mvvmexample.ui.featured

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.FeaturedLayoutBinding
import com.glory.mvvmexample.ui.home.adapter.FeaturedAdapter
import com.glory.mvvmexample.utils.Constants

class FeaturedActivity : BaseActivity<FeaturedLayoutBinding, FeaturedViewModel>() {
    override val viewModel: FeaturedViewModel by lazy { ViewModelProvider(this)[FeaturedViewModel::class.java] }
    override val layoutId: Int = R.layout.featured_layout

    private lateinit var featuredAdapter: FeaturedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.ivBack!!.setOnClickListener { onBackPressed() }

        binding?.rvFeatured!!.layoutManager = GridLayoutManager(this, 2)
        featuredAdapter = FeaturedAdapter(this)
        binding?.rvFeatured!!.adapter = featuredAdapter

        if (intent.hasExtra(Constants.EXTRA_FAVORITE)) {
            binding?.tvFeaturedTitle!!.text = "Favorite"
            viewModel.dataFavorite.observe(this) { data ->
                data.let {
                    featuredAdapter.clothesList(it)
                }
            }
        } else
        if (intent.hasExtra(Constants.EXTRA_FEATURED)) {

            viewModel.dataFeatured.observe(this) { data ->
                data.let {
                    featuredAdapter.clothesList(it)
                }
            }
        }
    }
}