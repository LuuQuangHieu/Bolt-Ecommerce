package com.glory.mvvmexample.ui.cart

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.CartLayoutBinding
import com.glory.mvvmexample.ui.address.AddressActivity

class CartActivity : BaseActivity<CartLayoutBinding, CartViewModel>() {
    override val viewModel: CartViewModel by lazy { ViewModelProvider(this)[CartViewModel::class.java] }
    override val layoutId: Int = R.layout.cart_layout


    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observesCartList()

        binding?.ivBack!!.setOnClickListener { onBackPressed() }
        binding?.btContinue!!.setOnClickListener {
            startActivity(Intent(this, AddressActivity::class.java))
        }
    }

    fun observesCartList() {
        binding?.rlCartList!!.layoutManager = GridLayoutManager(this, 1)
        cartAdapter = CartAdapter()
        binding?.rlCartList!!.adapter = cartAdapter

        cartAdapter.cartCallBack = object : CartCallBack {
            override fun onDeleteItem(position: Int) {
                viewModel.delete(position)
            }
        }
        viewModel.dataCart.observe(this) { data ->
            data.let {
                cartAdapter.cartList(it)
            }
        }
    }
}