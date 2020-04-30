package com.aba.core.ui

import android.content.Context
import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModelProvider
import com.aba.core.domain.data.SearchModel
import com.aba.core.extension.observeLiveData
import com.aba.core.network.ResultResponse
import com.aba.core.view.ErrorSuccessFragment
import com.aba.search.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SearchFragment : ErrorSuccessFragment() {

    @VisibleForTesting
    val viewModel: SearchViewModel by lazy {
        viewModelFactory.create(SearchViewModel::class.java)
    }


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun initView() {
//        observeLiveData(viewModel.searchLiveData) {
//            processResult(it)
//        }
    }

    override fun initViewListeners() {

    }


    override val contentResourceId: Int
        get() = R.layout.search_fragment

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    private fun processResult(result: ResultResponse<List<SearchModel>>) {

    }


}