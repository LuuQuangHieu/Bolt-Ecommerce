package com.glory.mvvmexample.ui.create_address

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.ui.address.Address

class CreateAddressViewModel : BaseViewModel() {
    var name = MutableLiveData<String>()
    var addressLane = MutableLiveData<String>()
    var city = MutableLiveData<String>()
    var postalCode = MutableLiveData<String>()
    var phone = MutableLiveData<String>()
    var addressMutableLiveData = MutableLiveData<Address>()

    fun getAddress(): MutableLiveData<Address> = addressMutableLiveData

    fun onClickAddAddress() {
        var address = Address(
            addressLane.value.toString() + ", " + city.value.toString() + "-" + postalCode.value.toString(),
            "House no: AC Building",
            "Road no: 78",
            false,
            name.value.toString(),
            city.value.toString(),
            postalCode.value.toString(),
            phone.value.toString()
        )
        addressMutableLiveData.value = address
        Log.e("onclick", "onclick address")
    }
}