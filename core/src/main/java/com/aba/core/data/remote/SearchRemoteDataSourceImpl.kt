package com.aba.core.data.remote

import com.aba.core.data.mapper.SearchMapper
import com.aba.core.data.model.TVSearchResponse
import com.aba.core.data.net.service.TVMazeService
import com.aba.core.domain.model.SearchModel
import io.reactivex.Observable
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val service: TVMazeService,
    private val mapper: SearchMapper
) : SearchRemoteDataSource {
    override fun search(query: String): Observable<List<SearchModel>> {
        return service.search(query)
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }
}