package com.glory.mvvmexample.ui.checkout

import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.data.model.Cart
import com.glory.mvvmexample.ui.cart.CartCallBack
import com.glory.mvvmexample.ui.cart.CartViewModel

class CheckoutViewModel : BaseViewModel(), CartCallBack {
    var dataCheckout = MutableLiveData<ArrayList<Cart>>()
    var cartViewModel = CartViewModel()

    init {
        dataCheckout.value = cartViewModel.dataCart.value
    }

    fun delete(position: Int) {
        dataCheckout.value!!.removeAt(position)
        dataCheckout.value = dataCheckout.value
    }

    override fun onDeleteItem(position: Int) {
        delete(position)
    }
}