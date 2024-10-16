package com.example.spaceflightnews.core.data.source.local

import com.example.spaceflightnews.core.data.source.local.entity.FlightNewsEntity
import com.example.spaceflightnews.core.data.source.local.room.FlightNewsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val flightNewsDao: FlightNewsDao){
    fun getAllNews(): Flow<List<FlightNewsEntity>> = flightNewsDao.getAllNews()

    fun getFavoriteNews(): Flow<List<FlightNewsEntity>> = flightNewsDao.getFavoriteNews()

    fun setFavoriteNews(flightNews: FlightNewsEntity, newsState: Boolean) {
        flightNews.isFavorite = newsState
        flightNewsDao.updateFavoriteFlightNews(flightNews)
    }
}