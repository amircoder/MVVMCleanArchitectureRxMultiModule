package com.aba.core.data.local.convertor

import androidx.room.TypeConverter
import com.google.gson.Gson

class ListConverter {

    @TypeConverter
    fun convertStringListToGson(chunk: List<String>) =  Gson().toJson(chunk)

    @TypeConverter
    fun convertGsonToStringList(value: String) =
        Gson().fromJson(value, Array<String>::class.java).toList()
}