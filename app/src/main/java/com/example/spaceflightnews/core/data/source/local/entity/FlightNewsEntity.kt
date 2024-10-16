package com.example.spaceflightnews.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flight_news")
data class FlightNewsEntity (
    @PrimaryKey
    val id: Int,

    @ColumnInfo("title")
    val title: String,

    @ColumnInfo("image_url")
    val imageUrl: String,

    @ColumnInfo("summary")
    val summary: String,

    @ColumnInfo("published_at")
    val publishedAt: String,

    @ColumnInfo("is_favorite")
    var isFavorite: Boolean = false
)