package com.example.mymichelin.data

import com.example.mymichelin.R
import com.example.mymichelin.model.Restaurant

class Datasource {
    fun loadRestaurant():List<Restaurant>{
        return listOf<Restaurant>(
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
            Restaurant(R.string.restaurant1),
        )
    }
}