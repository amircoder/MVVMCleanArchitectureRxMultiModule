package com.aba.core.base

import android.util.Log
import com.aba.core.base.BaseUseCase.Params
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.aba.core.rx.SchedulerProvider
import io.reactivex.Observable

abstract class ObservableUseCase<PARAMS : Params, result>
    (
    private val scheduler: SchedulerProvider,
    private val errorContainer: ErrorContainer
) :
    BaseUseCase<PARAMS, ResultResponse<result>> {


    protected abstract fun buildObservable(params: PARAMS): Observable<ResultResponse<result>>

    override fun execute(params: PARAMS): Observable<ResultResponse<result>> =
        Observable.just(Unit)
            // To complete process when error happened
            .concatMapDelayError { buildObservable(params) }
            .subscribeOn(scheduler.ioScheduler)
            .observeOn(scheduler.mainScheduler)
            .doOnError {
                for (elem in it.stackTrace){
                    Log.e("error", elem.toString())
                }
            }
            .onErrorReturn { ResultResponse.Failure(errorContainer.getError(it)) }

}