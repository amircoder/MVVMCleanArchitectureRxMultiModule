package com.aba.core.di

import android.app.Application
import com.aba.core.AppConfig
import com.aba.core.GlobalConfig
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

}