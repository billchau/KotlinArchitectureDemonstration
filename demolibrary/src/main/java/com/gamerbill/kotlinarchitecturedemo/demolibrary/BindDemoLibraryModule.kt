package com.gamerbill.kotlinarchitecturedemo.demolibrary

import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.ClientDashboardFragment
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.ClientModule
import com.gamerbill.kotlinarchitecturedemo.demolibrary.common.CommonModule
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.CurrencyConversionFragment
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.CurrencyConversionModule
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader.CurrencyHeaderFragment
import com.gamerbill.kotlinarchitecturedemo.demolibrary.dependencyinjectionscope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [CommonModule::class])
abstract class BindDemoLibraryModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [CurrencyConversionModule::class])
    abstract fun bindCurrencyConversionFragment(): CurrencyConversionFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CurrencyConversionModule::class])
    abstract fun bindCurrencyHeaderFragment(): CurrencyHeaderFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ClientModule::class])
    abstract fun bindClientDashboardFragment(): ClientDashboardFragment
}