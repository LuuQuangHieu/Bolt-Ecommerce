package com.glory.mvvmexample.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glory.mvvmexample.data.model.ErrorResponse
import com.glory.mvvmexample.data.model.SuccessResponse
import com.glory.mvvmexample.ui.home.HomeActivity
import kotlin.reflect.KClass

abstract class BaseViewModel : ViewModel() {
    var error = MutableLiveData<ErrorResponse>()
    var success = MutableLiveData<SuccessResponse>()

    fun sendError(message : String){
        error.value = ErrorResponse(message);
    }

    fun sendSuccess(message: String){
        success.value = SuccessResponse(message)
    }

    init {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}