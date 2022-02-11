package com.glory.mvvmexample.data.model

data class Clothes (
    var clothesName: String = "",
    var clothesPrice: String = "",
    var clothesImage: Int)

class Product : ArrayList<ProductItem>()

data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

data class Rating(
    val count: Int,
    val rate: Double
)