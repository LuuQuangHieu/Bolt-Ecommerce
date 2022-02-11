package com.glory.mvvmexample.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.data.model.Token
import com.glory.mvvmexample.data.share.DataLocalManager
import com.glory.mvvmexample.databinding.SplashLayoutBinding
import com.glory.mvvmexample.ui.home.HomeActivity
import com.glory.mvvmexample.ui.login.LoginActivity
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

class SplashActivity : BaseActivity<SplashLayoutBinding, SplashViewModel>() {
    override val viewModel: SplashViewModel by lazy { ViewModelProvider(this)[SplashViewModel::class.java] }
    override val layoutId: Int = R.layout.splash_layout

    var timeCurrent: Date? = null
    var timeStart: Date? = null
    private var timeBetweenTwoTimeAccess = 0.0
    private var timeSurvive = 5.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss a")
        val gson = Gson()
        val token: Token? = gson.fromJson(DataLocalManager.getString, Token::class.java)
        if (token?.token?.isNotEmpty() == true) {
            timeCurrent = Date()
            timeStart = sdf.parse(token?.timeStart)
            timeBetweenTwoTimeAccess =
                ((timeCurrent?.time!!.toDouble() - timeStart?.time!!.toDouble()) / (1000 * 60)) //minute
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (timeBetweenTwoTimeAccess >= timeSurvive || timeBetweenTwoTimeAccess == 0.0) {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
            if (timeBetweenTwoTimeAccess < timeSurvive && timeBetweenTwoTimeAccess != 0.0) {
                val intent = Intent(this@SplashActivity, HomeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
        }, 1500)
    }
}