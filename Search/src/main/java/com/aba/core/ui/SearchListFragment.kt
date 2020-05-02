package com.aba.core.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aba.core.domain.data.SearchModel
import com.aba.core.extension.observeLiveData
import com.aba.core.network.ResultResponse
import com.aba.core.network.util.ImageLoader
import com.aba.core.ui.list.SearchItemViewHolder
import com.aba.core.ui.list.SearchListAdapter
import com.aba.core.view.ErrorSuccessFragment
import com.aba.search.R
import javax.inject.Inject

class SearchListFragment : ErrorSuccessFragment(), SearchListAdapter.SearchAdapterCallback {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var imageLoader: ImageLoader
    @Inject
    lateinit var adapter: SearchListAdapter<SearchItemViewHolder>

    val viewModel by lazy {
        viewModelFactory.create(SearchViewModel::class.java)
    }

    override val contentResourceId: Int
        get() = R.layout.search_fragment

    override fun initView() {
    }

    override fun initViewListeners() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeLiveData(viewModel.searchLiveData){
            processResponseResult(it)
        }
    }

    private fun processResponseResult(result: ResultResponse<List<SearchModel>>) {
        when{
            result.isSuccess() -> {
                hideLoadingSpinner()
                loadData((result as ResultResponse.Success<List<SearchModel>>).data)
            }

            result.isFailure() -> {
                hideLoadingSpinner()
                displayCustomError(
                    "",
                    (result as ResultResponse.Failure<List<SearchModel>>).error.toString()
                )
            }
            else -> {
                hideLoadingSpinner()
            }
        }
    }

    private fun loadData(data: List<SearchModel>) {
        adapter.searchItems = data
    }

    override fun onSearchItem(item: SearchModel) {
        TODO("Not yet implemented")
    }


}