package com.glory.mvvmexample.data.share

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(private val mContext: Context) {
    fun putStringValue(key: String?, value: String?) {
        val sharedPreferences =
            mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getStringValue(key: String?): String? {
        val sharedPreferences =
            mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, "")
    }

    companion object {
        private const val MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCE"
    }
}