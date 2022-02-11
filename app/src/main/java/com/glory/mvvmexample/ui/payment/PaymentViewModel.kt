package com.glory.mvvmexample.ui.payment

import androidx.lifecycle.MutableLiveData
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseViewModel
import com.glory.mvvmexample.data.model.CreditCard

class PaymentViewModel: BaseViewModel() {
    var dataCards = MutableLiveData<ArrayList<CreditCard>>()

    init {
        dataCards.value = arrayListOf(
            CreditCard(R.drawable.credit_card),
                                        CreditCard(R.drawable.credit_card),
                                        CreditCard(R.drawable.credit_card)
        )
    }
}