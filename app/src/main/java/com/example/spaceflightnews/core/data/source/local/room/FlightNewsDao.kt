package com.example.spaceflightnews.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.spaceflightnews.core.data.source.local.entity.FlightNewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightNewsDao {

    @Query("SELECT * FROM flight_news")
    fun getAllNews(): Flow<List<FlightNewsEntity>>

    @Query("SELECT * FROM flight_news WHERE is_favorite = 1")
    fun getFavoriteNews(): Flow<List<FlightNewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlightNews(flightNews: List<FlightNewsEntity>)

    @Update
    fun updateFavoriteFlightNews(flightNews: FlightNewsEntity)
}