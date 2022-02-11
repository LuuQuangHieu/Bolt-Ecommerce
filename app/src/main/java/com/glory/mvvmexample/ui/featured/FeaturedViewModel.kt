package com.glory.mvvmexample.ui.featured

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.data.model.Product
import com.glory.mvvmexample.data.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeaturedViewModel : BaseViewModel() {
    var dataFeatured = MutableLiveData<Product>()
    var dataFavorite = MutableLiveData<Product>()

    var allProducts: Product? = null

    private fun getAllProduct(){
        viewModelScope.launch (Dispatchers.IO){
            val response = ApiService.api.getAllProducts()
            if (response.isSuccessful){
                allProducts = response.body()
                if (allProducts?.isNotEmpty() == true){
                    withContext(Dispatchers.Main){
                        dataFeatured.value = allProducts
                        dataFavorite.value = allProducts    //temporary
                    }
                }
            } else{
                sendError("Connection error")
            }
        }
    }

    init {
        getAllProduct()
    }
}