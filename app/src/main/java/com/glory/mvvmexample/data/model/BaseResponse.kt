package com.glory.mvvmexample.data.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    var msg: String? = "",
    val status: String = "false",
    @SerializedName("payload")
    val data : T
)