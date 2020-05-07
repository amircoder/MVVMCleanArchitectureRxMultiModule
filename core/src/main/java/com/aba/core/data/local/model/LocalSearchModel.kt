package com.aba.core.data.local.model

import androidx.room.Entity
import com.aba.core.BuildConfig

@Entity(tableName = BuildConfig.SEARCH_TABLE_NAME, primaryKeys = ["id"] )
data class LocalSearchModel(
    val id: Int,
    val score: Double,
    val genres: List<String>,
    val name: String,
    val language: String,
    val officialSite: String,
    val status: String,
    val type: String,
    val url: String,
    val mediumImage: String,
    val originalImage: String,
    val averageRating: Double
)