package com.aba.core.di

import com.aba.core.di.scope.PerFragment
import com.aba.core.ui.SearchListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class SearchFragmentBinding {
    @PerFragment
    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun contributeSearchFragment(): SearchListFragment
}