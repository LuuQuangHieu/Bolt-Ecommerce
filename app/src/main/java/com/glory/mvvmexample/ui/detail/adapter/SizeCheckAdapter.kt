package com.glory.mvvmexample.ui.detail.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glory.mvvmexample.databinding.SizeCheckItemBinding
import com.glory.mvvmexample.utils.SizeChecked

class SizeCheckAdapter : RecyclerView.Adapter<SizeCheckAdapter.ViewHolder>() {
    private var itemSizes: ArrayList<SizeChecked> = arrayListOf()

    class ViewHolder(view: SizeCheckItemBinding) : RecyclerView.ViewHolder(view.root) {
        val tvSizeItem = view.tvSizeItem
        val cvSizeItem = view.cvSizeItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: SizeCheckItemBinding =
            SizeCheckItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemSize = itemSizes[position]

        holder.tvSizeItem.text = itemSize.sizeTitle
        holder.itemView.setOnClickListener {
            holder.cvSizeItem.setCardBackgroundColor(Color.parseColor("#667eea"))
            holder.tvSizeItem.setTextColor(Color.parseColor("#ffffff"))
        }
    }

    fun sizeList(list: ArrayList<SizeChecked>) {
        itemSizes = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemSizes.size
    }
}

//todo tao 1 interface => onDeleteItem