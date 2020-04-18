package com.aba.core.domain.data


data class SearchModel(
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