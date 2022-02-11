package com.glory.mvvmexample.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<BIND : ViewDataBinding?, VM : BaseViewModel> : AppCompatActivity() {
    abstract val viewModel: VM
    var binding: BIND? = null
    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding?.executePendingBindings()
        binding!!.lifecycleOwner = this
        viewModel.error.observe(this, {
            Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
        })
        viewModel.success.observe(this,{
            Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
        })

    }
}