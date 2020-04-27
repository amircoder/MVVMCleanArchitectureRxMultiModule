package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.data.net.service.TVMazeService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
class ServiceModule {


    @Provides
    @Singleton
    fun provideTVMazeService(@NonNull retrofit: Retrofit): TVMazeService =
        retrofit.create(TVMazeService::class.java)

}