package com.aba.core.data.mapper

import com.aba.core.base.LocalMapper
import com.aba.core.data.local.model.LocalSearchModel
import com.aba.core.domain.model.SearchModel

class LocalSearchMapper: LocalMapper<List<LocalSearchModel>, List<SearchModel>> {
    override fun mapFromLocal(items: List<LocalSearchModel>): List<SearchModel> =
        mutableListOf<SearchModel>().apply {
            items.forEach { item ->
                add(
                    SearchModel(
                        id = item.id,
                        originalImage = item.originalImage ?: "",
                        mediumImage = item.mediumImage ?: "",
                        averageRating = item.averageRating ?: 0.0,
                        score = item.score,
                        genres = item.genres ?: listOf(),
                        url = item.url,
                        language = item.language,
                        name = item.name,
                        officialSite = item.officialSite ?: "",
                        status = item.status,
                        type = item.type
                    )
                )
            }
        }

    override fun mapToLocal(items: List<SearchModel>): List<LocalSearchModel> =
        mutableListOf<LocalSearchModel>().apply {
            items.forEach { item ->
                add(
                    LocalSearchModel(
                        id = item.id,
                        originalImage = item.originalImage ?: "",
                        mediumImage = item.mediumImage ?: "",
                        averageRating = item.averageRating ?: 0.0,
                        score = item.score,
                        genres = item.genres ?: listOf(),
                        url = item.url,
                        language = item.language,
                        name = item.name,
                        officialSite = item.officialSite ?: "",
                        status = item.status,
                        type = item.type
                    )
                )
            }
        }
}