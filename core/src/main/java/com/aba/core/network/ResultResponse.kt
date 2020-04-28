package com.aba.core.network

import com.aba.core.network.error.ErrorEntity

sealed class ResultResponse<T> {
    data class Success<T>(val data: T) : ResultResponse<T>()
    data class Failure<T> (val error: ErrorEntity) : ResultResponse<T>()
    class Loading<T> : ResultResponse<T>()


    fun isSuccess(): Boolean = this is Success<*>
    fun isFailure(): Boolean = this is Failure
    fun isLoading(): Boolean = this is Loading
    fun isEmpty(): Boolean {
        return if (isSuccess()){
            (this as Success<List<*>>).data.isEmpty()
        }else {
            true
        }
    }


}