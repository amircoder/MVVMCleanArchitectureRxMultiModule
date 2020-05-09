package com.aba.core.domain.usecase

import com.aba.core.base.BaseUseCase
import com.aba.core.base.ObservableUseCase
import com.aba.core.domain.model.SearchModel
import com.aba.core.domain.repository.SearchRepository
import com.aba.core.domain.usecase.SearchUseCase.SearchParams
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.aba.core.rx.SchedulerProvider
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
    schedulerProvider: SchedulerProvider,
    errorContainer: ErrorContainer
) : ObservableUseCase<SearchParams, List<SearchModel>>(
    schedulerProvider, errorContainer
) {


    override fun buildObservable(params: SearchParams): Observable<ResultResponse<List<SearchModel>>> =
        searchRepository.search(params.query).debounce(350, TimeUnit.MILLISECONDS)


    fun with(query: String) = SearchParams(query)

    data class SearchParams(val query: String) : BaseUseCase.Params


}