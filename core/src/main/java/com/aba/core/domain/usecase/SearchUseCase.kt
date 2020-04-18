package com.aba.core.domain.usecase

import com.aba.core.base.BaseUseCase
import com.aba.core.base.ObservableUseCase
import com.aba.core.domain.data.SearchModel
import com.aba.core.domain.repository.SearchRepository
import com.aba.core.domain.usecase.SearchUseCase.SearchParams
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.aba.core.rx.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
    private val schedulerProvider: SchedulerProvider,
    private val errorContainer: ErrorContainer
) : ObservableUseCase<SearchParams, List<SearchModel>>(
    schedulerProvider, errorContainer
) {

    override fun buildObservable(params: SearchParams): Observable<ResultResponse<List<SearchModel>>> =
        searchRepository.search(params.query)

    data class SearchParams(val query: String) : BaseUseCase.Params

}