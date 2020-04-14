package com.aba.core.di

import android.app.Application
import com.aba.core.AppConfig
import com.aba.core.GlobalConfig
import com.aba.core.ThemeProvider
import com.aba.core.navigation.AppFragmentNavigationHelper
import com.aba.core.navigation.FragmentNavigationHelper
import com.aba.core.theme.AppThemeProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    @Singleton
    fun provideContext(application: Application) = application.applicationContext

    @Provides
    @Singleton
    fun provideConfig(): GlobalConfig = AppConfig()

    @Provides
    @Singleton
    fun provideFragmentNavigation(): FragmentNavigationHelper = AppFragmentNavigationHelper()

    @Provides
    @Singleton
    fun provideTheme(): ThemeProvider = AppThemeProvider()
}