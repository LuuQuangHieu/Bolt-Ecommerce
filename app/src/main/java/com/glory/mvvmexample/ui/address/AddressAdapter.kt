package com.glory.mvvmexample.ui.address

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glory.mvvmexample.databinding.AddressItemBinding

class AddressAdapter : RecyclerView.Adapter<AddressAdapter.ViewHolder>() {
    class ViewHolder(view: AddressItemBinding) : RecyclerView.ViewHolder(view.root) {
        val binding = view
    }

    private var addressList: ArrayList<Address> = arrayListOf()

    private var selected = -1

    var onClick: OnItemClickListener? = null

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onClick = onItemClickListener
    }

    fun selection(position: Int) {
        selected = position
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: AddressItemBinding =
            AddressItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val address = addressList[position]
        holder.binding.address = address

        holder.binding.rbSelect.isChecked = (selected == position)
        holder.itemView.isSelected = (selected == position)

        holder.itemView.setOnClickListener {
            onClick?.onItemClick(holder.itemView, holder.adapterPosition)
        }

    }

    fun listAddress(list: ArrayList<Address>) {
        addressList = list
        notifyDataSetChanged()
    }

    override fun getItemCount() = addressList.size

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}