package com.example.michelin.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(restuarant: Restaurant)

    @Update
    suspend fun update(restuarant: Restaurant)

    @Delete
    suspend fun delete(restuarant: Restaurant)


}
