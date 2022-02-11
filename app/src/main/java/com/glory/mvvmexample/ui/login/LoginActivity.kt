package com.glory.mvvmexample.ui.login

import android.app.Dialog
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
import com.glory.mvvmexample.databinding.LoginLayoutBinding
import com.glory.mvvmexample.ui.home.HomeActivity
import com.glory.mvvmexample.ui.signup.SignupActivity

class LoginActivity : BaseActivity<LoginLayoutBinding, LoginViewModel>() {
    override val viewModel: LoginViewModel by lazy { ViewModelProvider(this)[LoginViewModel::class.java] }
    override val layoutId: Int = R.layout.login_layout

    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding?.viewmodel = viewModel

        binding?.tvDontHaveAccount!!.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        spanText()
        observeStatus()
        observeProgressBar()
    }

    fun spanText() {
        val spannable = SpannableString(resources.getString(R.string.tv_dont_have_account))
        spannable.setSpan(
            StyleSpan(Typeface.BOLD),
            22,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding?.tvDontHaveAccount!!.text = spannable
    }

    fun observeStatus(){
        viewModel.mStatus.observe(this,{
            if (it){
                val intent = Intent(this,HomeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
        })
    }
    fun observeProgressBar(){
        viewModel.loadData.observe(this,{
            if (it){
                showProgressDialog()
            } else{
                hideProgressDialog()
            }
        })
    }

    private fun showProgressDialog(){
        progressDialog = Dialog(this)
        progressDialog?.let {
            it.setContentView(R.layout.dialog_progress)
            it.show()
        }
    }

    private fun hideProgressDialog(){
        progressDialog?.dismiss()
    }

}