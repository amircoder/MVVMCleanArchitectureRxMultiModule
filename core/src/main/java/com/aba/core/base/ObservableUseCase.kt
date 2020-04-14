package com.aba.core.base

import com.aba.core.base.BaseUseCase.Params
import com.aba.core.rx.SchedulerProvider
import io.reactivex.Observable

abstract class ObservableUseCase<PARAMS: Params, result>
    (private val scheduler: SchedulerProvider): BaseUseCase<PARAMS, result> {

    protected abstract fun buildObservable(params: PARAMS): Observable<result>

    override fun execute(params: PARAMS): Observable<result> =
        buildObservable(params)
            .subscribeOn(scheduler.ioScheduler)
            .observeOn(scheduler.mainScheduler)

}