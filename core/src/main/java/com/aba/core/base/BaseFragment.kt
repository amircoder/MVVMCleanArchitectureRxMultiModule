package com.aba.core.base

import android.content.Context
import com.aba.core.navigation.FragmentNavigationHelper
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var fragmentNavigator: FragmentNavigationHelper

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

}