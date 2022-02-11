package com.glory.mvvmexample.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.HomeLayoutBinding
import com.glory.mvvmexample.ui.featured.FeaturedActivity
import com.glory.mvvmexample.ui.home.adapter.BestSellAdapter
import com.glory.mvvmexample.ui.home.adapter.CategoryAdapter
import com.glory.mvvmexample.ui.home.adapter.FeaturedAdapter
import com.glory.mvvmexample.ui.menu.MenuActivity
import com.glory.mvvmexample.utils.Constants

class HomeActivity : BaseActivity<HomeLayoutBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by lazy { ViewModelProvider(this)[HomeViewModel::class.java] }
    override val layoutId: Int = R.layout.home_layout

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var featuredAdapter: FeaturedAdapter
    private lateinit var bestSellAdapter: BestSellAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        observeCategory()
        observeFeatured()
        observeBestseller()

        binding?.ivMenuBar!!.setOnClickListener {
            startActivity(Intent(this, MenuActivity::class.java))
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)

        }
        binding?.tvSeeAllFeatured!!.setOnClickListener {
            val intent = Intent(this, FeaturedActivity::class.java)
            intent.putExtra(Constants.EXTRA_FEATURED, layoutId)
            startActivity(intent)
        }

    }

    fun observeCategory() {
        binding?.rvCategories!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryAdapter = CategoryAdapter(this@HomeActivity)
        binding?.rvCategories!!.adapter = categoryAdapter

        viewModel.dataCategories.observe(this) { data ->
            data.let {
                categoryAdapter.categoriesList(it)
            }
        }
    }

    fun observeFeatured() {
        binding?.rvFeatured!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        featuredAdapter = FeaturedAdapter(this)
        binding?.rvFeatured!!.adapter = featuredAdapter

        viewModel.dataClothes.observe(this) { data ->
            data.let {
                featuredAdapter.clothesList(it)
            }
        }
    }

    fun observeBestseller() {
        binding?.rvBestSell!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        bestSellAdapter = BestSellAdapter(this@HomeActivity)
        binding?.rvBestSell!!.adapter = bestSellAdapter

        viewModel.dataBestSeller.observe(this) { data ->
            data.let {
                bestSellAdapter.clothesList(it)
            }
        }
    }
}