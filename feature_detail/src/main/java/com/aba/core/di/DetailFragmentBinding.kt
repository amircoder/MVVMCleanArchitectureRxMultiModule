package com.aba.core.di

import com.aba.core.ui.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class DetailFragmentBinding {

    @ContributesAndroidInjector(modules = [DetailFragmentModule::class])
    abstract fun contributeDetailFragment(): DetailFragment
}