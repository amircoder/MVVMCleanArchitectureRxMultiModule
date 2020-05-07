package com.aba.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aba.core.BuildConfig
import com.aba.core.data.local.model.LocalSearchModel
import io.reactivex.Observable


@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(searchItems: List<LocalSearchModel>)

    @Query("SELECT * FROM ${BuildConfig.SEARCH_TABLE_NAME} WHERE name LIKE '%'||:tvTitle||'%'")
    fun getTvItems(tvTitle: String): Observable<List<LocalSearchModel>>

}