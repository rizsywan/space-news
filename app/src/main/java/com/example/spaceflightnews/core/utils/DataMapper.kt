package com.example.spaceflightnews.core.utils

import com.example.spaceflightnews.core.data.source.local.entity.FlightNewsEntity
import com.example.spaceflightnews.core.data.source.remote.response.FlightNewsResponse
import com.example.spaceflightnews.core.domain.model.FlightNews

object DataMapper {
    fun mapResponseToEntities(input: List<FlightNewsResponse>): List<FlightNewsEntity> {
        return input.map {
            FlightNewsEntity(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl,
                summary = it.summary,
                publishedAt = it.publishedAt,
            )
        }
    }

    fun mapEntitiesToDomain(input: List<FlightNewsEntity>): List<FlightNews> {
        return input.map {
            FlightNews(
                id = it.id,
                title = it.title,
                imageUrl = it.imageUrl,
                summary = it.summary,
                publishedAt = it.publishedAt,
                isFavorite = it.isFavorite,
            )
        }
    }

    fun mapDomainToEntity(input: FlightNews): FlightNewsEntity {
        return FlightNewsEntity(
            id = input.id,
            title = input.title,
            imageUrl = input.imageUrl,
            summary = input.summary,
            publishedAt = input.publishedAt,
            isFavorite = input.isFavorite,
        )
    }
}