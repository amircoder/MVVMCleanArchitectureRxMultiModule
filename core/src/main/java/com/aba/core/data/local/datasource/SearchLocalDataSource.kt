package com.aba.core.data.local.datasource

import com.aba.core.base.BaseDataSource
import com.aba.core.data.model.TVSearchResponse
import io.reactivex.Observable

interface SearchLocalDataSource: BaseDataSource {
    
    fun search(query: String): Observable<List<TVSearchResponse>>
    fun insert(items: List<TVSearchResponse>)
}