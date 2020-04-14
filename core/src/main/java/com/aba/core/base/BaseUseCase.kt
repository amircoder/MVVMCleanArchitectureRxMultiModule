package com.aba.core.base

import com.aba.core.base.BaseUseCase.Params
import io.reactivex.Observable

interface BaseUseCase<PARAMS: Params, result> {

    fun execute(params: PARAMS): Observable<result>

    abstract class Params
}