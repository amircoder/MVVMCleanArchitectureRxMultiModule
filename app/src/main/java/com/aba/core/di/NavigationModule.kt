package com.aba.core.di

import com.aba.core.MainNavigationActivity
import com.aba.core.navigation.AppFragmentNavigationHelper
import com.aba.core.navigation.FragmentNavigationHelper
import com.aba.core.navigation.NavigatorActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class NavigationModule {

//    @Binds
//    @Singleton
//    abstract fun provideActivityNavigator(mainNavigationActivity: MainNavigationActivity): MainNavigationActivity

    @Module
    companion object {
        @Provides
        @JvmStatic
        @Singleton
        fun provideFragmentNavigation(): FragmentNavigationHelper = AppFragmentNavigationHelper()
    }


}
