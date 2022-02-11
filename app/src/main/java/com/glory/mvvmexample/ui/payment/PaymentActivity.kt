package com.glory.mvvmexample.ui.payment

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.PaymentLayoutBinding
import com.glory.mvvmexample.ui.checkout.CheckoutActivity

class PaymentActivity : BaseActivity<PaymentLayoutBinding, PaymentViewModel>() {
    override val viewModel: PaymentViewModel by lazy { ViewModelProvider(this)[PaymentViewModel::class.java] }
    override val layoutId: Int = R.layout.payment_layout

    var creditCardAdapter = CreditCardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.ivBack!!.setOnClickListener { onBackPressed() }

        binding?.rvCreditCardList!!.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding?.rvCreditCardList!!.adapter = creditCardAdapter

        viewModel.dataCards.observe(this) { data ->
            data.let {
                creditCardAdapter.CreditCardList(it)
            }
        }

        binding?.btCheckout!!.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

    }
}