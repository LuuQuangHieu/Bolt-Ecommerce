package com.glory.mvvmexample.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.viewModel = viewModel
//        binding.tvHello.text = "Hello Hieu 1"

    }

}