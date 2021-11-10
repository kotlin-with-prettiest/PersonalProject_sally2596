package com.example.michelin


import androidx.lifecycle.*
import com.example.michelin.data.Restaurant
import com.example.michelin.data.RestaurantDao
import kotlinx.coroutines.launch

class RestaurantViewModel (private val restaurantDao: RestaurantDao) : ViewModel() {
    val allItems: LiveData<List<Restaurant>> = restaurantDao.getItems().asLiveData()

    fun addNewItem(restaurantName: String, restaurantLocation: String,restaurantRate:String){
        val newItem = getNewItemEntry(restaurantName, restaurantLocation,restaurantRate)
        insertItem(newItem)
    }

    private fun insertItem(restaurant: Restaurant) {
        viewModelScope.launch {
            restaurantDao.insert(restaurant)
        }
    }

    private fun updateItem(restaurant: Restaurant) {
        viewModelScope.launch {
            restaurantDao.update(restaurant)
        }
    }

    fun deleteItem(restaurant: Restaurant) {
        viewModelScope.launch {
            restaurantDao.delete(restaurant)
        }
    }
    private fun getUpdatedItemEntry(
        restaurantId: Int,
        restaurantName: String,
        restaurantLocation: String,
        restaurantRate: Double,
    ): Restaurant {
        return Restaurant(
            id = restaurantId,
            restaurantName = restaurantName,
            restaurantLocation = restaurantLocation,
            restaurantRate = restaurantRate,
        )
    }
    fun updateItem(
        restaurantId: Int,
        restaurantName: String,
        restaurantLocation: String,
        restaurantRate: Double,
    ) {
        val updatedItem = getUpdatedItemEntry(restaurantId, restaurantName, restaurantLocation,restaurantRate)
        updateItem(updatedItem)
    }
    /**
     * Returns an instance of the [Restaurant] entity class with the item info entered by the user.
     * This will be used to add a new entry to the Inventory database.
     */
    private fun getNewItemEntry(restaurantName: String, restaurantLocation: String,restaurantRate:String): Restaurant {
        return Restaurant(
            restaurantName = restaurantName,
            restaurantLocation = restaurantLocation,
            restaurantRate = restaurantRate.toDouble(),
        )
    }
}

/**
 * Factory class to instantiate the [ViewModel] instance.
 */
class RestaurantViewModelFactory(private val restaurantDao: RestaurantDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RestaurantViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RestaurantViewModel(restaurantDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
