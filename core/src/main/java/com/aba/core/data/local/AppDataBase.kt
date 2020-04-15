package com.aba.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aba.core.BuildConfig

//@Database(
//    entities = [],
//    version = 1,
//    exportSchema = false
//)
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
}