package com.glory.mvvmexample.ui.main

import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.base.BaseViewModel

class MainViewModel : BaseViewModel(){
    var helloText = MutableLiveData("Hello Hieu")

    fun setNewText(){
        helloText.value = "Hieu 2"
    }



}