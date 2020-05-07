package com.aba.core.rx

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ResultObserver<T>(
    private val liveData: MutableLiveData<T>,
    private val initBlock: (liveData: MutableLiveData<T>) -> Unit
): Observer<T> {
    override fun onComplete() {
        // Do Nothing
    }

    override fun onSubscribe(d: Disposable) {
        initBlock(liveData)
    }

    override fun onNext(t: T) {
        liveData.postValue(t)
    }

    override fun onError(e: Throwable) {
        Log.e("error", "Some error happened $e")
    }

}