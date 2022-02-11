package com.glory.mvvmexample.ui.address

import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.base.BaseViewModel

class AddressViewModel : BaseViewModel() {
    var dataAddress = MutableLiveData<ArrayList<Address>>()

    init {
        dataAddress.value = arrayListOf(
            Address(
                "Shewrapara, Mirpur, Dhaka-1216",
                "House no: 938",
                "Road no: 9",
                false,
                "Đức Bo",
                "Dhaka",
                "1234",
                "+84839992148"
            ),
            Address(
                "Chatkhil, Noakhali",
                "House no: 22",
                "Road no: 7",
                false,
                "Đức Bo",
                "Noakhali",
                "1234",
                "+84839992148"
            ),
            Address(
                "Hà Nội, Hà Đông",
                "House no: Km10",
                "Road no: Nguyễn Trãi",
                false,
                "Đức Bo",
                "Ha Dong",
                "1234",
                "+84839992148"
            )
        )
    }
}