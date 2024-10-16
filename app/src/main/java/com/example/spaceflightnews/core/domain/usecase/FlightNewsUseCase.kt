package com.example.spaceflightnews.core.domain.usecase

import com.example.spaceflightnews.core.data.NewsType
import com.example.spaceflightnews.core.data.Resource
import com.example.spaceflightnews.core.domain.model.FlightNews
import kotlinx.coroutines.flow.Flow

interface FlightNewsUseCase {
    fun getNews(type: NewsType): Flow<Resource<List<FlightNews>>>

    fun getFavoriteNews(): Flow<List<FlightNews>>

    fun setFavoriteNews(news: FlightNews, state: Boolean)
}