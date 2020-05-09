package com.aba.core.data.local.datasource

import com.aba.core.data.local.dao.SearchDao
import com.aba.core.data.mapper.LocalSearchMapper
import com.aba.core.domain.model.SearchModel
import com.aba.core.rx.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

class SearchLocalDataSourceImpl @Inject constructor(
    private val searchDao: SearchDao,
    private val mapper: LocalSearchMapper
    ): SearchLocalDataSource {
    override fun search(query: String): Observable<List<SearchModel>> {
        return searchDao.getTvItems(query)
            .map {
                mapper.mapFromLocal(it)
            }
    }

    override fun insert(items: List<SearchModel>) {
        searchDao.insert(mapper.mapToLocal(items))
    }
}