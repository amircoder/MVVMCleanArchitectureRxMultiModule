package com.aba.core.data.mapper

import com.aba.core.data.model.TVSearchResponse
import com.aba.core.domain.model.SearchModel
import javax.inject.Inject

class SearchMapper @Inject constructor() {

    fun map(items: List<TVSearchResponse>): List<SearchModel> =
        mutableListOf<SearchModel>().apply {
            items.forEach { item ->
                with(item.show) {
                    add(
                        SearchModel(
                            id = id,
                            originalImage = image?.original ?: "",
                            mediumImage = image?.medium ?: "",
                            averageRating = rating?.average ?: 0.0,
                            score = item.score,
                            genres = genres ?: listOf(),
                            url = url,
                            language = language,
                            name = name,
                            officialSite = officialSite ?: "",
                            status = status,
                            type = type
                        )
                    )
                }
            }
        }


}