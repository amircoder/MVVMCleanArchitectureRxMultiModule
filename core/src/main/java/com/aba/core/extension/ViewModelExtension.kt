package com.aba.core.extension

import com.aba.core.base.BaseViewModel
import io.reactivex.disposables.Disposable

operator fun<T: BaseViewModel> T.plusAssign(disposable: Disposable) = add(disposable)