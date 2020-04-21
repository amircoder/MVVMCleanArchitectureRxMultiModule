package com.aba.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aba.core.base.BaseViewModel
import com.aba.core.domain.data.SearchModel
import com.aba.core.domain.usecase.SearchUseCase
import com.aba.core.network.ResultResponse
import com.aba.core.rx.ResultSubscriber
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    val searchResult: LiveData<ResultResponse<List<SearchModel>>>
        get() = _searchResult
    private val _searchResult: MutableLiveData<ResultResponse<List<SearchModel>>> =
        MutableLiveData()

    fun searchFor(query: String) {
        add(
            searchUseCase.execute(searchUseCase.with(query))
                .startWith(ResultResponse.Loading())
                .subscribeWith(ResultSubscriber(_searchResult))
        )
    }
}