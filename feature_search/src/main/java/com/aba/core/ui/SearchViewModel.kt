package com.aba.core.ui

import androidx.lifecycle.MutableLiveData
import com.aba.core.base.BaseViewModel
import com.aba.core.domain.model.SearchModel
import com.aba.core.domain.usecase.SearchUseCase
import com.aba.core.extension.plusAssign
import com.aba.core.network.ResultResponse
import com.aba.core.rx.ResultSubscriber
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    val searchLiveData: MutableLiveData<ResultResponse<List<SearchModel>>>
        get() = _searchLiveData
    private val _searchLiveData = MutableLiveData<ResultResponse<List<SearchModel>>>()

    fun search(query: String) {
         this += searchUseCase.execute(searchUseCase.with(query))
            .subscribeWith(ResultSubscriber(_searchLiveData) { liveData ->
                // starts with
                liveData.postValue(ResultResponse.Loading())
            })

    }

}