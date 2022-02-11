package com.glory.mvvmexample.ui.home.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glory.mvvmexample.data.model.Category
import com.glory.mvvmexample.databinding.CategoryItemBinding

class CategoryAdapter(private val activity: Activity) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private var categories: List<Category> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CategoryItemBinding =
            CategoryItemBinding.inflate(LayoutInflater.from(activity), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]

        holder.binding.category = category
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun categoriesList(list: List<Category>) {
        categories = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: CategoryItemBinding) : RecyclerView.ViewHolder(view.root) {
        val binding = view
    }
}