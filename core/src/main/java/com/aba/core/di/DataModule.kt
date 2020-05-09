package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.data.local.datasource.SearchLocalDataSource
import com.aba.core.data.local.datasource.SearchLocalDataSourceImpl
import com.aba.core.data.mapper.LocalSearchMapper
import com.aba.core.data.mapper.SearchMapper
import com.aba.core.data.remote.SearchRemoteDataSource
import com.aba.core.data.remote.SearchRemoteDataSourceImpl
import com.aba.core.data.repository.SearchRepositoryImpl
import com.aba.core.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class DataModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideSearchMapper(): SearchMapper = SearchMapper()

        @JvmStatic
        @Provides
        fun provideLocalSearchMapper(): LocalSearchMapper = LocalSearchMapper()
    }

    @Binds
    abstract fun provideSearchRepository(
        @NonNull searchRepo: SearchRepositoryImpl
    ): SearchRepository


    @Binds
    abstract fun provideRemoteSearchDataSource(
        remoteDataSource: SearchRemoteDataSourceImpl
    ): SearchRemoteDataSource


    @Binds
    abstract fun provideLocalSearchDataSource(
        localDataSource: SearchLocalDataSourceImpl
    ): SearchLocalDataSource

}