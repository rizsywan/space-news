package com.example.spaceflightnews.core.domain.usecase

import com.example.spaceflightnews.core.data.NewsType
import com.example.spaceflightnews.core.data.Resource
import com.example.spaceflightnews.core.domain.model.FlightNews
import com.example.spaceflightnews.core.domain.repository.IFlightNewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlightNewsInteractor @Inject constructor(private val repository: IFlightNewsRepository): FlightNewsUseCase {
    override fun getNews(type: NewsType): Flow<Resource<List<FlightNews>>> {
        return repository.getNews(type)
    }

    override fun getFavoriteNews(): Flow<List<FlightNews>> {
        return repository.getFavoriteNews()
    }

    override fun setFavoriteNews(news: FlightNews, state: Boolean) {
        return repository.setFavoriteNews(news, state)
    }
}