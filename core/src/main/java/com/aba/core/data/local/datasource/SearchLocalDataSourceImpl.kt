package com.aba.core.data.local.datasource

import com.aba.core.data.local.dao.SearchDao
import com.aba.core.data.model.TVSearchResponse
import io.reactivex.Observable
import javax.inject.Inject

class SearchLocalDataSourceImpl @Inject constructor(
    private val searchDao: SearchDao
): SearchLocalDataSource {
    override fun search(query: String): Observable<List<TVSearchResponse>> {
        return searchDao.getTvItems(query)
    }

    override fun insert(items: List<TVSearchResponse>) {
        searchDao.insert(items)
    }
}