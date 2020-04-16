package com

import com.aba.core.data.model.TVSearchResponse
import java.util.*

const val SOME_TEXT = "night"
const val SOME_NAME = "Night Force"
const val SOME_STATUS = "Running"
const val SOME_TYPE = "Scripted"
const val SOME_LANGUAGE = "RUSSIAN"
const val SOME_ID = 1
const val SOME_URL = "http://www.tvmaze.com/shows/47071/night-force"

@JvmField
val SOME_ITEM: TVSearchResponse = TVSearchResponse(
    score = 10.0,
    show = TVSearchResponse.Show(
        genres = listOf("horror", "drama", "comedy"),
        id = SOME_ID,
        url = SOME_URL,
        language = SOME_LANGUAGE,
        name = SOME_NAME,
        officialSite = SOME_URL,
        status = SOME_STATUS,
        type = SOME_TYPE,
        rating = TVSearchResponse.Rating(3.0),
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
val SOME_ITEMS: List<TVSearchResponse> = Collections.singletonList(SOME_ITEM)