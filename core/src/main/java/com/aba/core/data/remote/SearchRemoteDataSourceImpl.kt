package com.aba.core.data.remote

import com.aba.core.data.model.TVSearchResponse
import com.aba.core.data.net.service.TVMazeService
import io.reactivex.Observable
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor(
    private val service: TVMazeService
) : SearchRemoteDataSource {
    override fun search(query: String): Observable<List<TVSearchResponse>> {
        return service.search(query)
    }
}