
package com.glory.mvvmexample.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.glory.mvvmexample.data.model.Cart
import com.glory.mvvmexample.databinding.CartItemBinding

class CartAdapter : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    private var itemsCart: ArrayList<Cart> = arrayListOf()

    var cartCallBack: CartCallBack? = null

    class ViewHolder(view: CartItemBinding) : RecyclerView.ViewHolder(view.root) {
        val binding = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: CartItemBinding =
            CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCart = itemsCart[position]
        holder.binding.itemCart = itemCart

        holder.binding.btPlus.setOnClickListener {
            itemCart.quantity++
            notifyItemChanged(position)
        }
        holder.binding.btSub.setOnClickListener {
            if (itemCart.quantity > 0) {
                itemCart.quantity--
                notifyItemChanged(position)
                if (itemCart.quantity == 0) {
                    cartCallBack?.onDeleteItem(position)
                }
            }
        }
        holder.binding.btRemoveItem.setOnClickListener {
            cartCallBack?.onDeleteItem(position)
        }
    }

    override fun getItemCount() = itemsCart.size

    fun cartList(list: ArrayList<Cart>) {
        itemsCart = list
        notifyDataSetChanged()
    }
}

interface CartCallBack { //avoid weak reference
    fun onDeleteItem(position: Int)
}