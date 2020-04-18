package com

import com.aba.core.data.model.TVSearchResponse
import com.aba.core.domain.data.SearchModel
import java.util.*

const val SOME_TEXT = "night"
const val SOME_NAME = "Night Force"
const val SOME_STATUS = "Running"
const val SOME_TYPE = "Scripted"
const val SOME_LANGUAGE = "RUSSIAN"
const val SOME_ID = 1
const val SOME_URL = "http://www.tvmaze.com/shows/47071/night-force"
const val SOME_SCORE = 10.0

const val SOME_OTHER_TEXT = "other night"
const val SOME_OTHER_NAME = "other Night Force"
const val SOME_OTHER_STATUS = "other Running"
const val SOME_OTHER_TYPE = "other Scripted"
const val SOME_OTHER_LANGUAGE = "other RUSSIAN"
const val SOME_OTHER_ID = 2
const val SOME_OTHER_URL = "http://www.tvmaze.com/shows/other/47071/night-force"
const val SOME_OTHER_SCORE = 11.0
val SOME_GENRES = listOf("horror", "drama", "comedy")
val SOME_OTHER_GENRES = listOf("other horror", "other drama", "other comedy")

@JvmField
val SOME_ITEM: TVSearchResponse = TVSearchResponse(
    score = SOME_SCORE,
    show = TVSearchResponse.Show(
        genres = SOME_GENRES,
        id = SOME_ID,
        url = SOME_URL,
        language = SOME_LANGUAGE,
        name = SOME_NAME,
        officialSite = SOME_URL,
        status = SOME_STATUS,
        type = SOME_TYPE,
        rating = TVSearchResponse.Rating(SOME_SCORE),
        image = TVSearchResponse.Image(
            SOME_URL,
            SOME_URL
        ),
        links = TVSearchResponse.Links(
            TVSearchResponse.PreviousEpisode(SOME_URL),
            TVSearchResponse.Self(SOME_URL)
        )
    )
)

@JvmField
val SOME_OTHER_ITEM: TVSearchResponse = TVSearchResponse(
    score = SOME_OTHER_SCORE,
    show = TVSearchResponse.Show(
        genres = SOME_OTHER_GENRES,
        id = SOME_OTHER_ID,
        url = SOME_OTHER_URL,
        language = SOME_OTHER_LANGUAGE,
        name = SOME_OTHER_NAME,
        officialSite = SOME_OTHER_URL,
        status = SOME_OTHER_STATUS,
        type = SOME_OTHER_TYPE,
        rating = TVSearchResponse.Rating(SOME_OTHER_SCORE),
        image = TVSearchResponse.Image(
            SOME_OTHER_URL,
            SOME_OTHER_URL
        ),
        links = TVSearchResponse.Links(
            TVSearchResponse.PreviousEpisode(SOME_OTHER_URL),
            TVSearchResponse.Self(SOME_OTHER_URL)
        )
    )
)

val SOME_SEARCH_MODEL = SearchModel(
    id = SOME_ID,
    type = SOME_TYPE,
    status = SOME_STATUS,
    officialSite = SOME_URL,
    name = SOME_NAME,
    language = SOME_LANGUAGE,
    url = SOME_URL,
    genres = SOME_GENRES,
    score = SOME_SCORE,
    averageRating = SOME_SCORE,
    mediumImage = SOME_URL,
    originalImage = SOME_URL
)

val SOME_OTHER_SEARCH_MODEL = SearchModel(
    id = SOME_OTHER_ID,
    type = SOME_OTHER_TYPE,
    status = SOME_OTHER_STATUS,
    officialSite = SOME_OTHER_URL,
    name = SOME_OTHER_NAME,
    language = SOME_OTHER_LANGUAGE,
    url = SOME_OTHER_URL,
    genres = SOME_OTHER_GENRES,
    score = SOME_OTHER_SCORE,
    averageRating = SOME_OTHER_SCORE,
    mediumImage = SOME_OTHER_URL,
    originalImage = SOME_OTHER_URL
)

@JvmField
val SOME_SEARCH_RESPONSE_ITEMS: List<TVSearchResponse> = Collections.singletonList(SOME_ITEM)

@JvmField
val SOME_OTHER_SEARCH_RESPONSE_ITEMS: List<TVSearchResponse> =
    Collections.singletonList(SOME_OTHER_ITEM)

@JvmField
val SOME_COMBINED_SEARCH_RESPONSE_ITEMS: List<TVSearchResponse> = listOf(SOME_ITEM, SOME_OTHER_ITEM)

@JvmField
val SOME_SEARCH_MODELS = Collections.singletonList(SOME_SEARCH_MODEL)
val SOME_OTHER_SEARCH_MODELS = Collections.singletonList(SOME_OTHER_SEARCH_MODEL)
val SOME_COMBINED_SEARCH_MODELS = listOf(SOME_SEARCH_MODEL, SOME_OTHER_SEARCH_MODEL)
