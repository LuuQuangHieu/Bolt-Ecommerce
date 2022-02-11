package com.glory.mvvmexample.ui.cart

import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.data.model.Cart

class CartViewModel : BaseViewModel(), CartCallBack {

    var dataCart = MutableLiveData<ArrayList<Cart>>()

    init {
        dataCart.value = arrayListOf(
            Cart("Woman T-Shirt", "Spring", "$50.00", R.drawable.woman_t_shirt, 1),
            Cart("Man T-Shirt", "Summer", "$60.00", R.drawable.man_t_shirt, 1),
            Cart("Kid Sweater", "Winter", "$35.00", R.drawable.kid_len, 1),
            Cart("Woman T-Shirt", "Autumn", "$45.00", R.drawable.woman_t_shirt_2, 1),
            Cart("Man T-Shirt", "Spring", "$25.00", R.drawable.man_t_shirt_2, 1),
            Cart("Woman T-Shirt", "Autumn", "$50.00", R.drawable.kid_len_2, 1)
        )
    }

    fun delete(position: Int) {
        dataCart.value!!.removeAt(position)
        dataCart.value = dataCart.value
    }

    override fun onDeleteItem(position: Int) {
        delete(position)
    }
}