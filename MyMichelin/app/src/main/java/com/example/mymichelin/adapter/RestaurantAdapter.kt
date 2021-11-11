package com.example.mymichelin.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mymichelin.R
import com.example.mymichelin.RestaurantListFragmentDirections
import com.example.mymichelin.model.Restaurant

class RestaurantAdapter(
    private val context: Context,
    private val dataset: List<Restaurant>
) : RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {


    class RestaurantViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val restNameView = view.findViewById<TextView>(R.id.rest_name)
        val restRateView = view.findViewById<TextView>(R.id.rest_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.restaurant_list_item, parent, false)
        return RestaurantViewHolder(layout)
    }


    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val name = dataset[position]
        holder.restNameView.text = name.restaurantName
        holder.restRateView.text = name.restaurantRate.toString()

        holder.restNameView.setOnClickListener{
            val action = RestaurantListFragmentDirections.actionRestaurantListFragmentToRestaurantDetailFragment(name.restaurantName,name.restaurantLocation,name.restaurantRate.toFloat(),name.restaurantNote)
            holder.view.findNavController().navigate(action)
        }

    }

    override fun getItemCount() = dataset.size
}