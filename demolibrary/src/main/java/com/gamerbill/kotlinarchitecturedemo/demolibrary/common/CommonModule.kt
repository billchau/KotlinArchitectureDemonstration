package com.gamerbill.kotlinarchitecturedemo.demolibrary.common

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CommonModule {

    @Provides
    @Singleton
    fun provideCurrencyPreference(context: Context) : CurrencyPreference = CurrencyPreference(context)

}