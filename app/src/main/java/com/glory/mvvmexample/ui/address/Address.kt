package com.glory.mvvmexample.ui.address

import android.os.Parcelable
import android.util.Patterns
import kotlinx.parcelize.Parcelize

@Parcelize
class Address(
    var laneCity: String,
    var houseNo: String,
    var roadNo: String,
    var isSelect: Boolean,
    var name: String,
    var city: String,
    var postalCode: String,
    var phone: String
) : Parcelable {

    fun isValidName(): Boolean {
        return name.isNotEmpty()
    }

    fun isValidAddressLane(): Boolean {
        return laneCity.isNotEmpty()
    }

    fun isValidCity(): Boolean {
        return city.isNotEmpty()
    }

    fun isValidPostalCode(): Boolean {
        return Patterns.PHONE.matcher(postalCode).matches()
    }

    fun isValidPhone(): Boolean {
        return Patterns.PHONE.matcher(phone).matches()
    }
}
