package com.glory.mvvmexample.data.model

import com.glory.mvvmexample.utils.SizeChecked

class Repository(){
    val list: List<SizeChecked> = arrayListOf(
        SizeChecked(1, "S", false),
        SizeChecked(2,"M", true),
        SizeChecked(3,"L", false),
        SizeChecked(4,"XL", false),
        SizeChecked(5, "XXL",false)
    )
}