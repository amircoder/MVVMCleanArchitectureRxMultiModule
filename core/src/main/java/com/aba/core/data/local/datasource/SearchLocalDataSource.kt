package com.aba.core.data.local.datasource

import com.aba.core.base.BaseDataSource
import com.aba.core.data.model.TVSearchResponse
import com.aba.core.domain.model.SearchModel
import io.reactivex.Observable

interface SearchLocalDataSource: BaseDataSource {
    
    fun search(query: String): Observable<List<SearchModel>>
    fun insert(items: List<SearchModel>)
}