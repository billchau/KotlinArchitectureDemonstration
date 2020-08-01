package com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion

import com.gamerbill.kotlinarchitecturedemo.democontract.DemoPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.DemoLibraryFramework
import com.gamerbill.kotlinarchitecturedemo.demolibrary.common.CurrencyPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader.CurrencyHeaderContract
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader.CurrencyHeaderPresenter
import com.gamerbill.kotlinarchitecturedemo.demolibrary.util.DateTimeUtil
import dagger.Module
import dagger.Provides

@Module(includes = [DemoLibraryFramework::class])
class CurrencyConversionModule {
    @Provides
    fun provideCurrencyConversionPresenter(currencyPreference: DemoPreference) : CurrencyConversionContract.Presenter = CurrencyConversionPresenter(currencyPreference)

    @Provides
    fun provideCurrencyHeaderPresenter(dateTimeUtil: DateTimeUtil) : CurrencyHeaderContract.Presenter = CurrencyHeaderPresenter(dateTimeUtil)
}

