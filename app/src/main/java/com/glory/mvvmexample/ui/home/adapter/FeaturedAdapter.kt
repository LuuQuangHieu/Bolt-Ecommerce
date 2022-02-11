package com.glory.mvvmexample.ui.home.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glory.mvvmexample.data.model.ProductItem
import com.glory.mvvmexample.databinding.FeaturedItemBinding
import com.glory.mvvmexample.ui.detail.ItemDetailsActivity

class FeaturedAdapter(private val context: Context) :
    RecyclerView.Adapter<FeaturedAdapter.ViewHolder>() {

    private var featuredClothes: ArrayList<ProductItem> = arrayListOf()


    fun clothesList(list: ArrayList<ProductItem>) {
        featuredClothes = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FeaturedItemBinding =
            FeaturedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val featuredCloth = featuredClothes[position]

        holder.binding.productItem = featuredCloth


        holder.itemView.setOnClickListener {
            val intent = Intent(context, ItemDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return featuredClothes.size
    }

    class ViewHolder(view: FeaturedItemBinding) : RecyclerView.ViewHolder(view.root) {
        var binding = view

    }
}