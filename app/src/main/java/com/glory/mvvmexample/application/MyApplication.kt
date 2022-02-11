package com.glory.mvvmexample.application

import android.app.Application
import com.glory.mvvmexample.data.share.DataLocalManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DataLocalManager.init(applicationContext)
    }
}