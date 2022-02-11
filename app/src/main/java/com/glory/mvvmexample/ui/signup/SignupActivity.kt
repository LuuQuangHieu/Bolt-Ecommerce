package com.glory.mvvmexample.ui.signup

import android.graphics.Typeface
import android.icu.util.TimeUnit.values
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.SignupLayoutBinding
import java.time.chrono.JapaneseEra.values

class SignupActivity: BaseActivity<SignupLayoutBinding, SignupViewModel>() {
    override val viewModel: SignupViewModel by lazy { ViewModelProvider(this)[SignupViewModel::class.java] }
    override val layoutId: Int = R.layout.signup_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding?.btBackFromSignup!!.setOnClickListener { onBackPressed() }

        binding?.tvAlreadyAccount!!.setOnClickListener { onBackPressed() }

        val spannable = SpannableString(resources.getString(R.string.tv_already_account))
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            25,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding?.tvAlreadyAccount!!.text = spannable
    }

}