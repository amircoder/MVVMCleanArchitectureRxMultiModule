package com.aba.core.data.repository

import com.aba.core.data.local.datasource.SearchLocalDataSource
import com.aba.core.data.remote.SearchRemoteDataSource
import com.aba.core.domain.model.SearchModel
import com.aba.core.domain.repository.SearchRepository
import com.aba.core.network.ResultResponse
import io.reactivex.Observable
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource,
    private val localDataSource: SearchLocalDataSource
) : SearchRepository {

    override fun search(query: String): Observable<ResultResponse<List<SearchModel>>> =
        Observable.concatArrayEagerDelayError(
            localDataSource.search(query), callRemote(query)
        ).flatMap {
            Observable.just(ResultResponse.Success(it))
        }


    private fun callRemote(query: String) = remoteDataSource.search(query).doOnNext {
        if (it.isNotEmpty())
            localDataSource.insert(it)
    }
}
