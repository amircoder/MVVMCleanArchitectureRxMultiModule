package com.aba.core.domain.model

import android.os.Parcel
import android.os.Parcelable


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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeDouble(score)
        parcel.writeStringList(genres)
        parcel.writeString(name)
        parcel.writeString(language)
        parcel.writeString(officialSite)
        parcel.writeString(status)
        parcel.writeString(type)
        parcel.writeString(url)
        parcel.writeString(mediumImage)
        parcel.writeString(originalImage)
        parcel.writeDouble(averageRating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchModel> {
        override fun createFromParcel(parcel: Parcel): SearchModel {
            return SearchModel(parcel)
        }

        override fun newArray(size: Int): Array<SearchModel?> {
            return arrayOfNulls(size)
        }
    }
}