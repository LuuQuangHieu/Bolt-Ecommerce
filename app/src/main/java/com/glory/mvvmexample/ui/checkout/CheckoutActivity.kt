package com.glory.mvvmexample.ui.checkout

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.CheckoutLayoutBinding
import com.glory.mvvmexample.ui.cart.CartAdapter
import com.glory.mvvmexample.ui.cart.CartCallBack
import com.glory.mvvmexample.ui.confirm.ConfirmActivity

class CheckoutActivity : BaseActivity<CheckoutLayoutBinding, CheckoutViewModel>() {
    override val viewModel: CheckoutViewModel by lazy { ViewModelProvider(this)[CheckoutViewModel::class.java] }
    override val layoutId: Int = R.layout.checkout_layout

    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.ivBack!!.setOnClickListener { onBackPressed() }

        binding?.rvCheckoutItem!!.layoutManager = GridLayoutManager(this, 1)
        adapter = CartAdapter()
        binding?.rvCheckoutItem!!.adapter = adapter

        adapter.cartCallBack = object : CartCallBack {
            override fun onDeleteItem(position: Int) {
                viewModel.delete(position)
            }
        }

        viewModel.dataCheckout.observe(this) { data ->
            data.let {
                adapter.cartList(it)
            }
        }

        binding?.btBuy!!.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java)
            startActivity(intent)
        }
    }
}