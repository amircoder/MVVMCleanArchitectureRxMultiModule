package com.aba.core.ui

import com.aba.core.view.ErrorSuccessFragment
import com.aba.search.R
import javax.inject.Inject

class SearchFragment : ErrorSuccessFragment(){

    @Inject
    lateinit var viewModel: SearchViewModel

    override fun initView() {
    }

    override fun initViewListeners() {
    }

    override val contentResourceId: Int
        get() = R.layout.search_fragment
}