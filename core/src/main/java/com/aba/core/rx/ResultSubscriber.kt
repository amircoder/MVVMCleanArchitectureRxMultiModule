package com.aba.core.rx

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.observers.DisposableObserver

class ResultSubscriber<T>(
    private val liveData: MutableLiveData<T>
): DisposableObserver<T>() {

    override fun onError(e: Throwable) {
        Log.e("error", "Some error happened $e")
    }

    override fun onNext(t: T) {
        liveData.postValue(t)
    }

    override fun onComplete() {
        // Do Nothing
    }
}