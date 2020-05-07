package com.aba.core.domain.repository

import com.aba.core.base.BaseRepository
import com.aba.core.domain.model.SearchModel
import com.aba.core.network.ResultResponse
import io.reactivex.Observable

interface SearchRepository: BaseRepository {
    fun search(query: String): Observable<ResultResponse<List<SearchModel>>>
}