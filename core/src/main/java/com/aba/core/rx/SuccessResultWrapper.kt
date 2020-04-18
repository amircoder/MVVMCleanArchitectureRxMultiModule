package com.aba.core.rx

import com.aba.core.network.ResultResponse
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class SuccessResultWrapper<T> @Inject constructor() :
    ObservableTransformer<T, ResultResponse<T>> {
    override fun apply(upstream: Observable<T>): ObservableSource<ResultResponse<T>> =
        upstream.flatMap {
            Observable.just(
                ResultResponse.Success(it)
            )
        }


}