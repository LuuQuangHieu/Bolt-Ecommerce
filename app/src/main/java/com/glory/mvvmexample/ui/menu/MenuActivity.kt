package com.glory.mvvmexample.ui.menu

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.MenuLayoutBinding
import com.glory.mvvmexample.ui.cart.CartActivity
import com.glory.mvvmexample.ui.featured.FeaturedActivity
import com.glory.mvvmexample.ui.profile.ProfileActivity
import com.glory.mvvmexample.utils.Constants


class MenuActivity : BaseActivity<MenuLayoutBinding, MenuViewModel>() {
    override val viewModel: MenuViewModel by lazy { ViewModelProvider(this)[MenuViewModel::class.java] }
    override val layoutId: Int = R.layout.menu_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.ivBack!!.setOnClickListener { onBackPressed() }
        binding?.tvHome!!.setOnClickListener { onBackPressed() }
        binding?.tvProfile!!.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
        binding?.tvCart!!.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra(Constants.EXTRA_CART, layoutId)
            startActivity(intent)
            finish()
        }
        binding?.tvMyOrders!!.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra(Constants.EXTRA_MY_ORDERS, layoutId)
            startActivity(intent)
            finish()
        }
        binding?.tvFavorite!!.setOnClickListener {
            val intent = Intent(this, FeaturedActivity::class.java)
            intent.putExtra(Constants.EXTRA_FAVORITE, layoutId)
            startActivity(intent)
            finish()
        }

    }
}