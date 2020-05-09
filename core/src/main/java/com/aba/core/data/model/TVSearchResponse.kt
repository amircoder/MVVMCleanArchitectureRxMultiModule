package com.aba.core.data.model



import com.google.gson.annotations.SerializedName

data class TVSearchResponse(
    @SerializedName("score")
    var score: Double ,
    @SerializedName("show")
    var show: Show
) {
    data class Show(
//        @SerializedName("externals")
//        var externals: Externals? ,
        @SerializedName("genres")
        var genres: List<String>? ,
        @SerializedName("id")
        var id: Int,
        @SerializedName("image")
        var image: Image? ,
        @SerializedName("language")
        var language: String = "" ,
        @SerializedName("_links")
        var links: Links?,
        @SerializedName("name")
        var name: String,
//        @SerializedName("network")
//        var network: Network? ,
        @SerializedName("officialSite")
        var officialSite: String?,
//        @SerializedName("premiered")
//        var premiered: String,
        @SerializedName("rating")
        var rating: Rating? ,
//        @SerializedName("runtime")
//        var runtime: Int,
//        @SerializedName("schedule")
//        var schedule: Schedule?,
        @SerializedName("status")
        var status: String,
//        @SerializedName("summary")
//        var summary: String,
        @SerializedName("type")
        var type: String,
//        @SerializedName("updated")
//        var updated: Int? = 0,
        @SerializedName("url")
        var url: String
//        @SerializedName("weight")
//        var weight: Int
    )

    data class Image(
        @SerializedName("medium")
        var medium: String,
        @SerializedName("original")
        var original: String
    )

//    data class Network(
//        @SerializedName("country")
//        var country: Country? ,
//        @SerializedName("id")
//        var id: Int? ,
//        @SerializedName("name")
//        var name: String = ""
//    )

//    data class Externals(
//        @SerializedName("imdb")
//        var imdb: String = "",
//        @SerializedName("thetvdb")
//        var thetvdb: Int? ,
//        @SerializedName("tvrage")
//        var tvrage: Int?
//    )

//    data class Country(
//        @SerializedName("code")
//        var code: String = "" ,
//        @SerializedName("name")
//        var name: String = "" ,
//        @SerializedName("timezone")
//        var timezone: String = ""
//    )

    data class Links(
        @SerializedName("previousepisode")
        var previousepisode: PreviousEpisode ,
        @SerializedName("self")
        var self: Self
    )


    data class Rating(
        @SerializedName("average")
        var average: Double?
    )

//    data class Schedule(
//        @SerializedName("days")
//        var days: List<String = "">?,
//        @SerializedName("time")
//        var time: String = ""
//    )

    data class Self(
        @SerializedName("href")
        var selfHref: String = ""
    )

    data class PreviousEpisode(
        @SerializedName("href")
        var PreviousEpisodeHref: String = ""
    )
}