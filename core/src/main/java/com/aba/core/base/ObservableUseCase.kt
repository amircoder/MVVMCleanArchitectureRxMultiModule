package com.aba.core.base

import com.aba.core.base.BaseUseCase.Params
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.aba.core.rx.SchedulerProvider
import io.reactivex.Observable

abstract class ObservableUseCase<PARAMS : Params, result>
    (private val scheduler: SchedulerProvider,
    private val errorContainer: ErrorContainer) :
    BaseUseCase<PARAMS, ResultResponse<result>> {

    protected abstract fun buildObservable(params: PARAMS): Observable<ResultResponse<result>>

    override fun execute(params: PARAMS): Observable<ResultResponse<result>> =
        buildObservable(params)
            .subscribeOn(scheduler.ioScheduler)
            .observeOn(scheduler.mainScheduler)
            .onErrorReturn {
                ResultResponse.Failure(errorContainer.getError(it))
            }

}