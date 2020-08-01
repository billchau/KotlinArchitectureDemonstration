package com.gamerbill.kotlinarchitecturedemo

import com.gamerbill.kotlinarchitecturedemo.democontract.DemoConfig
import com.gamerbill.kotlinarchitecturedemo.democontract.DemoFeature
import com.gamerbill.kotlinarchitecturedemo.demolibrary.DemoLibraryImpl
import com.gamerbill.kotlinarchitecturedemo.demolibrary.networking.RetrofitProvider
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class DemoModule {
    @Provides
    @Singleton
    fun provideDemoFeature(): DemoFeature{
        return DemoLibraryImpl()
    }

    @Provides
    @Singleton
    fun provideDemoConfig(@Named("demoretrofit") retrofit: Retrofit) : DemoConfig {
        return DemoConfigImpl(retrofit)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().build()
    }

    @Provides
    @Singleton
    @Named("demoretrofit")
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        // you may add interceptor here
        return RetrofitProvider(baseUrl = Config.baseUrl, okHttpClient = okHttpClient).get()
    }
}