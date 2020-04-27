package com.aba.core.di

import android.content.Context
import androidx.annotation.NonNull
import com.aba.core.BuildConfig
import com.aba.core.DataConstants
import com.aba.core.data.net.service.TVMazeService
import com.aba.core.di.scope.PerApplication
import com.aba.core.network.error.ErrorContainer
import com.aba.core.network.error.GeneralHandlerImpl
import com.aba.core.network.util.ImageLoader
import com.aba.core.network.util.ImageLoaderImpl
import com.aba.core.network.util.NetworkInterceptor
import com.aba.core.rx.RxErrorHandlingCallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient(context: Context): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(NetworkInterceptor())
            .addInterceptor(ChuckInterceptor(context))
            .readTimeout(DataConstants.Network.TIME_OUT.toLong(), TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    @Provides
    @Singleton
    fun provideRetrofit(
        @NonNull client: OkHttpClient,
        @NonNull errorContainer: ErrorContainer
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create(errorContainer))
        .build()

    @Singleton
    @Provides
    fun provideErrorHandler(errorHandler: GeneralHandlerImpl): ErrorContainer = errorHandler

    @Singleton
    @Provides
    fun provideImageLoader(imageLoader: ImageLoaderImpl): ImageLoader = imageLoader

}