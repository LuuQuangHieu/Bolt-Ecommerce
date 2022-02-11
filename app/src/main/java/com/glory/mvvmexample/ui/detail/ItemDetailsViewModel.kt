package com.glory.mvvmexample.ui.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.utils.SizeChecked

class ItemDetailsViewModel : BaseViewModel() {
    var dataSize = MutableLiveData<ArrayList<SizeChecked>>()

    init {
        dataSize.value = arrayListOf(
            SizeChecked(1, "S", false),
            SizeChecked(2, "M", true),
            SizeChecked(3, "L", false),
            SizeChecked(4, "XL", false),
            SizeChecked(5, "XXL", false)
        )
        Log.e("Initrun", "run")
    }

    fun delete(position: Int) {
        dataSize.value!!.removeAt(position)
        dataSize.value = dataSize.value
        Log.e("deleterun", "delete")

    }
}