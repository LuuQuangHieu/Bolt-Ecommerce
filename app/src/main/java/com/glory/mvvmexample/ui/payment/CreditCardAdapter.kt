package com.glory.mvvmexample.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glory.mvvmexample.data.model.CreditCard
import com.glory.mvvmexample.databinding.CreditCardItemBinding

class CreditCardAdapter : RecyclerView.Adapter<CreditCardAdapter.ViewHolder>() {

    private var itemsCreditCard: ArrayList<CreditCard> = arrayListOf()

    fun CreditCardList(list: ArrayList<CreditCard>) {
        itemsCreditCard = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: CreditCardItemBinding) : RecyclerView.ViewHolder(view.root) {
        val binding = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CreditCardItemBinding =
            CreditCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCard = itemsCreditCard[position]
        holder.binding.itemCard = itemCard
    }

    override fun getItemCount(): Int {
        return itemsCreditCard.size
    }
}