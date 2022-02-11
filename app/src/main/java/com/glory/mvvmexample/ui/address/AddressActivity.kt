package com.glory.mvvmexample.ui.address

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.AddressLayoutBinding
import com.glory.mvvmexample.ui.create_address.CreateAddressActivity
import com.glory.mvvmexample.ui.payment.PaymentActivity
import com.glory.mvvmexample.utils.Constants

class AddressActivity : BaseActivity<AddressLayoutBinding, AddressViewModel>() {
    override val viewModel: AddressViewModel by lazy { ViewModelProvider(this)[AddressViewModel::class.java] }
    override val layoutId: Int = R.layout.address_layout

    private lateinit var addressAdapter: AddressAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.ivBack!!.setOnClickListener { onBackPressed() }
        binding?.btAddAddress!!.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    CreateAddressActivity::class.java
                )
            )
        }
        binding?.btContinueToPayment!!.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    PaymentActivity::class.java
                )
            )
        }

        if (intent.hasExtra(Constants.EXTRA_CREATE_ADDRESS)) {
            var address: Address? = intent.getParcelableExtra(Constants.EXTRA_CREATE_ADDRESS)
            viewModel.dataAddress.value!!.add(address!!)
            viewModel.dataAddress.value = viewModel.dataAddress.value
        }

        binding?.rlAddressList!!.layoutManager = GridLayoutManager(this, 1)
        addressAdapter = AddressAdapter()
        binding?.rlAddressList!!.adapter = addressAdapter

        addressAdapter.setOnItemClickListener(object : AddressAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                addressAdapter.selection(position)
            }
        })

        viewModel.dataAddress.observe(this) { data ->
            data.let {
                addressAdapter.listAddress(it)
            }
        }
    }
}