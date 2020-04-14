package com.aba.core.extension

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun CompositeDisposable.plusAssign(disposable: Disposable) = add(disposable)