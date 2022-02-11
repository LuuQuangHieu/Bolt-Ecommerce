package com.glory.mvvmexample.ui.login

import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.data.model.ErrorResponse
import com.glory.mvvmexample.data.model.Token
import com.glory.mvvmexample.data.model.User
import com.glory.mvvmexample.data.network.ApiService
import com.glory.mvvmexample.data.share.DataLocalManager
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*


class LoginViewModel : BaseViewModel() {
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var mStatus = MutableLiveData<Boolean>(false)
    var loadData = MutableLiveData<Boolean>(false)

    private fun validateLogin(user: User) {
        if (!user.isValidUsername()) {
            sendError("Invalid Username")
            return
        }
        if (!user.isValidPassword()) {
            sendError("Invalid Password")
            return
        }
        sendUser()

    }

    private fun sendUser() {
        loadData.value = true

        val user = User(username.value, password.value)
        ApiService.api.sendUser(user).enqueue(object : retrofit2.Callback<Token?> {

            override fun onResponse(call: Call<Token?>, response: Response<Token?>) {
                //STATUS 200 CHUA "STATUS"
                //todo gson parse
                val gson = Gson()
                val errorResponse: String? = response.errorBody()?.string()
                val token: Token? = response.body()
                if (errorResponse?.isNotEmpty() == true) {
                    val error: ErrorResponse =
                        gson.fromJson(errorResponse, ErrorResponse::class.java)
                    sendError(error.msg)
                    mStatus.value = false
                    loadData.value = false
                    return
                }
                if (token?.token?.isNotEmpty() == true) {
                    //Save token and the time receive response
                    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss a")
                    token.timeStart = sdf.format(Date())
                    val tokenJson: String = gson.toJson(token)
                    DataLocalManager.setString(tokenJson)

                    sendSuccess("Login success")
                    mStatus.value = true
                    loadData.value = false
                    return
                }
            }

            override fun onFailure(call: Call<Token?>, t: Throwable) {
                sendError("Connection error")
                loadData.value = false
            }
        }
        )
    }

    fun onClickLogin() {
        val user = User(username.value.toString(), password.value.toString())
        validateLogin(user)
    }
}