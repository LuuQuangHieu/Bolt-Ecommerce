package com.glory.mvvmexample.ui.create_address

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.glory.mvvmexample.R
import com.glory.mvvmexample.base.BaseActivity
import com.glory.mvvmexample.databinding.CreateAddressLayoutBinding
import com.glory.mvvmexample.ui.address.Address
import com.glory.mvvmexample.ui.address.AddressActivity
import com.glory.mvvmexample.utils.Constants

class CreateAddressActivity : BaseActivity<CreateAddressLayoutBinding, CreateAddressViewModel>() {
    override val viewModel: CreateAddressViewModel by lazy { ViewModelProvider(this)[CreateAddressViewModel::class.java] }
    override val layoutId: Int = R.layout.create_address_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.viewModel = viewModel
        binding?.ivBack!!.setOnClickListener { onBackPressed() }

        viewModel.getAddress().observe(this) { address ->
            address.let {
                if (!it.isValidName()) {
                    Toast.makeText(this, "Name do not empty!", Toast.LENGTH_SHORT).show()
                } else if (!it.isValidPhone()) {
                    Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
                } else if (!it.isValidAddressLane()) {
                    Toast.makeText(this, "Address lane is not empty", Toast.LENGTH_SHORT).show()
                } else if (!it.isValidCity()) {
                    Toast.makeText(this, "City is not empty", Toast.LENGTH_SHORT).show()
                } else if (!it.isValidPostalCode()) {
                    Toast.makeText(this, "Invalid postal code", Toast.LENGTH_SHORT).show()
                } else {
                    var addressSender: Address? = it
                    val intent = Intent(this, AddressActivity::class.java)
                    intent.putExtra(Constants.EXTRA_CREATE_ADDRESS, it)
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    startActivity(intent)
                }
            }
        }
    }
}