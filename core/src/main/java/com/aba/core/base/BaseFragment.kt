package com.aba.core.base

import android.content.Context
import com.aba.core.navigation.FragmentNavigationHelper
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var fragmentNavigator: FragmentNavigationHelper

    protected abstract val contentResourceId: Int



    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)

    }

}