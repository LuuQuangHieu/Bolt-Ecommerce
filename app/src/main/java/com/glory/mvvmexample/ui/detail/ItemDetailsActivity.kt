package com.glory.mvvmexample.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.ItemDetailsLayoutBinding
import com.glory.mvvmexample.ui.address.AddressActivity
import com.glory.mvvmexample.ui.detail.adapter.ImageSlideAdapter
import com.glory.mvvmexample.ui.detail.adapter.SizeCheckAdapter

class ItemDetailsActivity : BaseActivity<ItemDetailsLayoutBinding, ItemDetailsViewModel>() {
    override val viewModel: ItemDetailsViewModel by lazy { ViewModelProvider(this)[ItemDetailsViewModel::class.java] }
    override val layoutId: Int = R.layout.item_details_layout

    private lateinit var sizeCheckAdapter: SizeCheckAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.ivBack!!.setOnClickListener { onBackPressed() }

        binding?.rvCheckSize!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        sizeCheckAdapter = SizeCheckAdapter()
        binding?.rvCheckSize!!.adapter = sizeCheckAdapter

        setSlideImage()

        viewModel.dataSize.observe(this) { data ->
            data.let {
                sizeCheckAdapter.sizeList(it)
            }
        }

        binding?.btBuyNow!!.setOnClickListener {
            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setSlideImage() {
        var list =
            listOf(R.drawable.woman_t_shirt, R.drawable.man_t_shirt, R.drawable.kid_len)
        var imageSlideAdapter = ImageSlideAdapter(list)
        binding?.vpImageSlide!!.adapter = imageSlideAdapter
        binding?.indicator!!.setViewPager(binding?.vpImageSlide)
    }
}