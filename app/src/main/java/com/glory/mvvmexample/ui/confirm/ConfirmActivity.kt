package com.glory.mvvmexample.ui.confirm

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.ConfirmLayoutBinding
import com.glory.mvvmexample.ui.home.HomeActivity

class ConfirmActivity : BaseActivity<ConfirmLayoutBinding, ConfirmViewModel>() {
    override val viewModel: ConfirmViewModel by lazy { ViewModelProvider(this)[ConfirmViewModel::class.java] }
    override val layoutId: Int = R.layout.confirm_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.btBackToHome!!.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}