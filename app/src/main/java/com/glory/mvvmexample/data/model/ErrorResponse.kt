package com.glory.mvvmexample.data.model

data class ErrorResponse(
    val msg: String,
    val status: String = "false"
)