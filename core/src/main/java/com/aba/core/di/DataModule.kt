package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.data.local.dao.SearchDao
import com.aba.core.data.local.datasource.SearchLocalDataSource
import com.aba.core.data.local.datasource.SearchLocalDataSourceImpl
import com.aba.core.data.mapper.SearchMapper
import com.aba.core.data.net.service.TVMazeService
import com.aba.core.data.remote.SearchRemoteDataSource
import com.aba.core.data.remote.SearchRemoteDataSourceImpl
import com.aba.core.data.repository.SearchRepositoryImpl
import com.aba.core.domain.repository.SearchRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideSearchRepository(
        @NonNull remoteDataSource: SearchRemoteDataSource,
        @NonNull localDataSource: SearchLocalDataSource,
        @NonNull searchMapper: SearchMapper
    ): SearchRepository =
        SearchRepositoryImpl(remoteDataSource, localDataSource, searchMapper)

    @Provides
    @Singleton
    fun provideRemoteSearchDataSource(
        service: TVMazeService
    ): SearchRemoteDataSource =
        SearchRemoteDataSourceImpl(service)

    @Provides
    @Singleton
    fun provideLocalSearchDataSource(
        searchDao: SearchDao
    ): SearchLocalDataSource =
        SearchLocalDataSourceImpl(searchDao)

    @Provides
    @Singleton
    fun provideSearchMapper(): SearchMapper = SearchMapper()
}