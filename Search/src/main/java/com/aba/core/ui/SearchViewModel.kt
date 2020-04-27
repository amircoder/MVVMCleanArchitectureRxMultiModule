package com.aba.core.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aba.core.base.BaseViewModel
import com.aba.core.domain.data.SearchModel
import com.aba.core.domain.usecase.SearchUseCase
import com.aba.core.network.ResultResponse
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
): BaseViewModel() {

    val searchLiveData: LiveData<ResultResponse<List<SearchModel>>>
        get() = _searchLiveData
    private val _searchLiveData = MutableLiveData<ResultResponse<List<SearchModel>>>()

    fun search(query: String) {
        _searchLiveData.postValue(null)
    }
}