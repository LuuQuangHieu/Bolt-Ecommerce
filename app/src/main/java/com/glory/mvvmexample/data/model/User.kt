package com.glory.mvvmexample.data.model

import android.util.Patterns

class User(var username: String?, var password: String?) {
//     private var email: String = email
//     private var password: String = password

    fun isValidUsername(): Boolean {
        return username?.isNotEmpty()== true
    }

    fun isValidPassword(): Boolean {
        return password != null && password!!.length  >= 6
    }
}