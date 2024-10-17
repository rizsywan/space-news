package com.example.spaceflightnews.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FlightNews(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val summary: String,
    val publishedAt: String,
    val isFavorite: Boolean,
): Parcelable
