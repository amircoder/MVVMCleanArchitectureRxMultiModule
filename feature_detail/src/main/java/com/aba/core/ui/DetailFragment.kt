package com.aba.core.ui

import com.aba.core.delegate.FragmentBundleDelegate
import com.aba.core.domain.model.SearchModel
import com.aba.core.navigation.NavigationKeys
import com.aba.core.view.ErrorSuccessFragment
import com.aba.detail.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: ErrorSuccessFragment() {

    private val tvInfo: SearchModel? by FragmentBundleDelegate(NavigationKeys.TV_INFO_KEY)

    override fun initView() {
        tvInfo?.apply {
            title.text = name
        }
    }

    override fun initViewListeners() {

    }

    override val contentResourceId: Int
        get() = R.layout.fragment_detail
}