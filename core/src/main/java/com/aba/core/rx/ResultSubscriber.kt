package com.aba.core.rx

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorEntity
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver

class ResultSubscriber<T>(
    private val liveData: MutableLiveData<T>,
    private val initBlock: (liveData: MutableLiveData<T>) -> Unit
): DisposableObserver<T>() {

    override fun onStart() {
        super.onStart()
        initBlock(liveData)
    }

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