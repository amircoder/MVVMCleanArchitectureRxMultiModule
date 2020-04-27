package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.di.scope.PerApplication
import com.aba.core.domain.repository.SearchRepository
import com.aba.core.domain.usecase.SearchUseCase
import com.aba.core.network.error.ErrorContainer
import com.aba.core.rx.SchedulerProvider
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule  {

    @Provides
    @PerApplication
    fun provideSearchUseCase(
        @NonNull searchRepository: SearchRepository,
        @NonNull schedulerProvider: SchedulerProvider,
        @NonNull errorContainer: ErrorContainer
    ) : SearchUseCase =
        SearchUseCase(
            searchRepository,
            schedulerProvider,
            errorContainer
        )

}