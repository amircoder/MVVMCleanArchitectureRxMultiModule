package com.aba.core.di

import android.content.Context
import com.aba.core.data.local.AppDataBase
import com.aba.core.data.local.dao.SearchDao
import com.aba.core.di.scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class LocalDataModule {


    @Provides
    @PerApplication
    fun provideDataBase(context: Context): AppDataBase = AppDataBase.create(context)

    @Provides
    @PerApplication
    fun provideSearchDao(appDataBase: AppDataBase): SearchDao = appDataBase.getSearchDao()

}