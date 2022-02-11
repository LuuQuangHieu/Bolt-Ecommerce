package com.glory.mvvmexample.ui.screen

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.ScreenLayoutBinding
import com.glory.mvvmexample.ui.login.LoginActivity
import com.glory.mvvmexample.ui.signup.SignupActivity

class ScreenActivity : BaseActivity<ScreenLayoutBinding, ScreenViewModel>() {
    override val viewModel: ScreenViewModel by lazy { ViewModelProvider(this)[ScreenViewModel::class.java] }
    override val layoutId: Int = R.layout.screen_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding?.viewModel = viewModel

        //Adjust multiple font in one textview
        val spannable = SpannableString(resources.getString(R.string.tv_welcome_bolt))
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            10,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding?.tvWelcomeBolt!!.text = spannable

        binding?.btLogin!!.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding?.tvSignup!!.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}