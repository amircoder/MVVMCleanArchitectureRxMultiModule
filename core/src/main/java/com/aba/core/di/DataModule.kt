package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.data.local.dao.SearchDao
import com.aba.core.data.local.datasource.SearchLocalDataSource
import com.aba.core.data.local.datasource.SearchLocalDataSourceImpl
import com.aba.core.data.mapper.LocalSearchMapper
import com.aba.core.data.mapper.SearchMapper
import com.aba.core.data.net.service.TVMazeService
import com.aba.core.data.remote.SearchRemoteDataSource
import com.aba.core.data.remote.SearchRemoteDataSourceImpl
import com.aba.core.data.repository.SearchRepositoryImpl
import com.aba.core.domain.repository.SearchRepository
import com.aba.core.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideSearchRepository(
        @NonNull remoteDataSource: SearchRemoteDataSource,
        @NonNull localDataSource: SearchLocalDataSource
    ): SearchRepository =
        SearchRepositoryImpl(remoteDataSource, localDataSource)

    @Provides
    @Singleton
    fun provideRemoteSearchDataSource(
        service: TVMazeService,
        searchMapper: SearchMapper
    ): SearchRemoteDataSource =
        SearchRemoteDataSourceImpl(service, searchMapper)

    @Provides
    @Singleton
    fun provideLocalSearchDataSource(
        searchDao: SearchDao,
        mapper: LocalSearchMapper
    ): SearchLocalDataSource =
        SearchLocalDataSourceImpl(searchDao, mapper)

    @Provides
    @Singleton
    fun provideSearchMapper(): SearchMapper = SearchMapper()

    @Provides
    @Singleton
    fun provideLocalSearchMapper(): LocalSearchMapper = LocalSearchMapper()
}