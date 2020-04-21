package com.aba.core.di

import com.aba.core.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class SearchFragmentBinding {
    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun contributesSearchFragment(): SearchFragment
}