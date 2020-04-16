package com.aba.core.data.remote

import com.aba.core.base.BaseDataSource
import com.aba.core.data.model.TVSearchResponse
import io.reactivex.Observable

interface SearchRemoteDataSource: BaseDataSource {
    fun search(query: String): Observable<List<TVSearchResponse>>
}