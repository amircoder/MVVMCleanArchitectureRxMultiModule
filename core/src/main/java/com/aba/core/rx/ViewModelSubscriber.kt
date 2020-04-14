package com.aba.core.rx

import androidx.lifecycle.MutableLiveData
import com.aba.core.base.ResultResponse
import io.reactivex.observers.DisposableSingleObserver

class ViewModelSubscriber<T: ResultResponse<R>, R>(
    private val liveData: MutableLiveData<T>
): DisposableSingleObserver<T>() {
    override fun onSuccess(t: T) {
        liveData.postValue(t)
    }

    override fun onError(e: Throwable) {
        liveData.postValue(ResultResponse.Failure<R>(e) as T)
    }
}