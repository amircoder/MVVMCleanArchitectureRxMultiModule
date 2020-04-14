package com.aba.core.extension

import com.aba.core.base.BaseViewModel
import io.reactivex.disposables.Disposable

fun BaseViewModel.plusAssign(disposable: Disposable) = add(disposable)