package com.aba.core.data.model


import com.google.gson.annotations.SerializedName

data class searchResponse(
    @SerializedName("score")
    val score: Double ,
    @SerializedName("show")
    val show: Show
) {
    data class Show(
        @SerializedName("externals")
        val externals: Externals? ,
        @SerializedName("genres")
        val genres: List<String?>? ,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: Image? ,
        @SerializedName("language")
        val language: String? = "",
        @SerializedName("_links")
        val links: Links?,
        @SerializedName("name")
        val name: String,
        @SerializedName("network")
        val network: Network? ,
        @SerializedName("officialSite")
        val officialSite: String,
        @SerializedName("premiered")
        val premiered: String,
        @SerializedName("rating")
        val rating: Rating? ,
        @SerializedName("runtime")
        val runtime: Int,
        @SerializedName("schedule")
        val schedule: Schedule?,
        @SerializedName("status")
        val status: String,
        @SerializedName("summary")
        val summary: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("updated")
        val updated: Int? = 0,
        @SerializedName("url")
        val url: String,
        @SerializedName("weight")
        val weight: Int
    )

    data class Image(
        @SerializedName("medium")
        val medium: String,
        @SerializedName("original")
        val original: String
    )

    data class Network(
        @SerializedName("country")
        val country: Country? ,
        @SerializedName("id")
        val id: Int? ,
        @SerializedName("name")
        val name: String?
    )

    data class Externals(
        @SerializedName("imdb")
        val imdb: String?,
        @SerializedName("thetvdb")
        val thetvdb: Int? ,
        @SerializedName("tvrage")
        val tvrage: Int?
    )

    data class Country(
        @SerializedName("code")
        val code: String? ,
        @SerializedName("name")
        val name: String? ,
        @SerializedName("timezone")
        val timezone: String?
    )

    data class Links(
        @SerializedName("previousepisode")
        val previousepisode: PreviousEpisode? ,
        @SerializedName("self")
        val self: Self?
    )


    data class Rating(
        @SerializedName("average")
        val average: Double?
    )

    data class Schedule(
        @SerializedName("days")
        val days: List<String?>?,
        @SerializedName("time")
        val time: String?
    )

    data class Self(
        @SerializedName("href")
        val href: String?
    )

    data class PreviousEpisode(
        @SerializedName("href")
        val href: String?
    )
}