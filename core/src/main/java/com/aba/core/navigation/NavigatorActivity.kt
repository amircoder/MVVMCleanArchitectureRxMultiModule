package com.aba.core.navigation

import androidx.navigation.fragment.FragmentNavigator


interface NavigatorActivity {
    fun navigateToDetail(extras: FragmentNavigator.Extras)
}