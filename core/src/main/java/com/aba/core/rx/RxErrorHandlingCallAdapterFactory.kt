package com.aba.core.rx

import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class RxErrorHandlingCallAdapterFactory(
) : CallAdapter.Factory() {


    companion object {
        private lateinit var original: RxJava2CallAdapterFactory
        private lateinit var errorContainer: ErrorContainer
        fun create(errorHandler: ErrorContainer): CallAdapter.Factory {
            errorContainer = errorHandler
            return RxJava2CallAdapterFactory.create().apply {
                original = this
            }
        }
    }

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        return RxCallAdapterWrapper(retrofit, original as CallAdapter<Any, Any>)
    }

    private class RxCallAdapterWrapper(
        private val retrofit: Retrofit,
        private val wrapped: CallAdapter<Any, Any>
    ) : CallAdapter<Any, Observable<Any>> {
        override fun adapt(call: Call<Any>): Observable<Any> =
            (wrapped.adapt(call) as Observable<Any>)
                .onErrorReturn {
                    Observable.just<Any>(ResultResponse.Failure<Any>(errorContainer.getError(it)))
                }

        override fun responseType(): Type = wrapped.responseType()

    }

}