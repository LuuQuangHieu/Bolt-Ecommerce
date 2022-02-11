package com.glory.mvvmexample.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.data.model.Category
import com.glory.mvvmexample.data.model.Clothes
import com.glory.mvvmexample.data.model.Product
import com.glory.mvvmexample.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {
    var dataCategories = MutableLiveData<ArrayList<Category>>()
    var dataClothes = MutableLiveData<Product>()
    var dataBestSeller = MutableLiveData<ArrayList<Clothes>>()

    var categories: ArrayList<String>? = null
    var limitProducts: Product? = null

    private fun getCategory(){
        viewModelScope.launch(Dispatchers.IO){
            val response = ApiService.api.getCategory()
            if (response.isSuccessful){
                categories = response.body()
                if (categories?.isNotEmpty() == true){
                    withContext(Dispatchers.Main){
                        dataCategories.value = arrayListOf(
                            Category(categories?.get(0), "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg", R.drawable.blue_alpha),
                            Category(categories?.get(1), "https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg" , R.drawable.red_alpha),
                            Category(categories?.get(2), "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg", R.drawable.green_alpha),
                            Category(categories?.get(3), "https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_.jpg", R.drawable.blue_alpha)
                        )
                    }
                }
            }else{
                sendError("Connection error")
            }
        }
    }

    private fun getLimitProduct(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = ApiService.api.getLimitProducts()
            if (response.isSuccessful){
                limitProducts = response.body()
                if (limitProducts?.isNotEmpty() == true){
                    withContext(Dispatchers.Main){
                        dataClothes.value = limitProducts
                    }
                }
            } else{
                sendError("Connection error")
            }
        }
    }

    init {
        getCategory()
        getLimitProduct()

        dataBestSeller.value = arrayListOf(
            Clothes("Woman T-Shirt", "$50.00", R.drawable.kid_len_2),
            Clothes("Man T-Shirt", "$25.00", R.drawable.man_t_shirt_2),
            Clothes("Woman T-Shirt", "$45.00", R.drawable.woman_t_shirt_2),
            Clothes("Kid Sweater", "$35.00", R.drawable.kid_len),
            Clothes("Man T-Shirt", "$60.00", R.drawable.man_t_shirt),
            Clothes("Woman T-Shirt", "$50.00", R.drawable.woman_t_shirt)
        )

    }
}