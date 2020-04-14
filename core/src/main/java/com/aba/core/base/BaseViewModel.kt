package com.aba.core.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private val disposables: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun add(subject: Disposable) {
        disposables.add(subject)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}