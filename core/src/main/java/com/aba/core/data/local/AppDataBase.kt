package com.aba.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aba.core.BuildConfig
import com.aba.core.data.local.convertor.ListConverter
import com.aba.core.data.local.dao.SearchDao
import com.aba.core.data.local.model.LocalSearchModel

@Database(
    entities = [(LocalSearchModel::class)],
    version = 1,
    exportSchema = false
)
@TypeConverters(ListConverter::class)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        fun create(context: Context): AppDataBase =
            Room.databaseBuilder(
                context,
                AppDataBase::class.java,
                BuildConfig.DB_NAME
            ).allowMainThreadQueries().build()

        fun getTestInstance(context: Context) =
            Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    abstract fun getSearchDao(): SearchDao
}