package com.aba.core.navigation

import android.os.Bundle
import androidx.navigation.fragment.FragmentNavigator


interface NavigatorActivity {


    fun navigateToDetail(bundle: Bundle, extras: FragmentNavigator.Extras)

}