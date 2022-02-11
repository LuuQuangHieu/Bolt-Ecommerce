package com.glory.mvvmexample.ui.profile

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.ProfileLayoutBinding

class ProfileActivity : BaseActivity<ProfileLayoutBinding, ProfileViewModel>() {
    override val viewModel: ProfileViewModel by lazy { ViewModelProvider(this)[ProfileViewModel::class.java] }
    override val layoutId: Int = R.layout.profile_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.ivBack!!.setOnClickListener { onBackPressed() }
    }
}