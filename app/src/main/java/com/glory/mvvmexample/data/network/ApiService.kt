package com.glory.mvvmexample.data.network

import com.glory.mvvmexample.data.model.Product
import com.glory.mvvmexample.data.model.Token
import com.glory.mvvmexample.data.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    fun sendUser(@Body user: User?): Call<Token?>

    @GET("products/categories")
    suspend fun getCategory(): Response<ArrayList<String>>

    @GET("products?limit=5")
    suspend fun getLimitProducts(): Response<Product>

    @GET("products")
    suspend fun getAllProducts(): Response<Product>

    companion object {
        val api = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}