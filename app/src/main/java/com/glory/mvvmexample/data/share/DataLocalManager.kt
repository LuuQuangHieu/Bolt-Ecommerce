package com.glory.mvvmexample.data.share

import android.content.Context
import com.glory.mvvmexample.utils.Constants
import com.glory.mvvmexample.utils.Constants.PREF_FIRST_INSTALL

class DataLocalManager {
    private var mySharedPreferences: MySharedPreferences? = null

    companion object {
        private var instance: DataLocalManager? = null
        fun init(context: Context?) {
            instance = DataLocalManager()
            instance!!.mySharedPreferences = MySharedPreferences(context!!)
        }

        fun getInstance(): DataLocalManager? {
            if (instance == null) {
                instance = DataLocalManager()
            }
            return instance
        }

        fun setString(stringValue: String?) {
            getInstance()!!.mySharedPreferences!!.putStringValue(PREF_FIRST_INSTALL, stringValue)
        }

        val getString: String?
            get() = getInstance()!!.mySharedPreferences!!.getStringValue(PREF_FIRST_INSTALL)
    }
}