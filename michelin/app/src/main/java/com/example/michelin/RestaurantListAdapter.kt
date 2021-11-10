package com.example.michelin

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.michelin.data.Restaurant
import com.example.michelin.databinding.RestaurantListItemBinding

class RestaurantListAdapter(private val onItemClicked: (Restaurant) -> Unit) : ListAdapter<Restaurant, RestaurantListAdapter.RestaurantViewHolder>(DiffCallback) {

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Restaurant>() {
            override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
                return oldItem.restaurantName == newItem.restaurantName
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(
            RestaurantListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current)
    }


    class RestaurantViewHolder(private var binding: RestaurantListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Restaurant) {
            binding.apply {
                restName.text = item.restaurantName
                restRate.text = item.restaurantRate.toString()
            }
        }
    }
}