package com.aba.core.di

import android.app.Application
import com.aba.core.di.scope.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@PerApplication
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class,
        LocalDataModule::class,
        UseCaseModule::class,
        ServiceModule::class,
        RxModule::class,
        MainActivityBinding::class
//        SearchFragmentBinding::class
//        DetailFragmentBinding::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}