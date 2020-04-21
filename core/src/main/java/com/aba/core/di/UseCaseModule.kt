package com.aba.core.di

import com.aba.core.di.scope.PerApplication
import com.aba.core.domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule  {

    @Provides
    @PerApplication
    fun provideSearchUse(searchUseCase: SearchUseCase) : SearchUseCase = searchUseCase

}