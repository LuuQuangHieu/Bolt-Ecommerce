package com.glory.mvvmexample.ui.home.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glory.mvvmexample.data.model.Clothes
import com.glory.mvvmexample.databinding.FeaturedItemBinding
import com.glory.mvvmexample.ui.detail.ItemDetailsActivity

class BestSellAdapter(private val context: Context) :
    RecyclerView.Adapter<BestSellAdapter.ViewHolder>() {

    private var bestSellClothes: List<Clothes> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: FeaturedItemBinding =
            FeaturedItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bestSellCloth = bestSellClothes[position]

        holder.tvClothesName.text = bestSellCloth.clothesName
        holder.tvClothesPrice.text = bestSellCloth.clothesPrice
        holder.ivClothesImage.setImageResource(bestSellCloth.clothesImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ItemDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return bestSellClothes.size
    }

    fun clothesList(list: List<Clothes>) {
        bestSellClothes = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: FeaturedItemBinding) : RecyclerView.ViewHolder(view.root) {
        val tvClothesName = view.tvClothesName
        val tvClothesPrice = view.tvClothesPrice
        val ivClothesImage = view.ivClothesItem
    }
}