package com.gamerbill.kotlinarchitecturedemo

import androidx.annotation.VisibleForTesting
import com.gamerbill.kotlinarchitecturedemo.demolibrary.BindDemoLibraryModule
import com.gamerbill.kotlinarchitecturedemo.demolibrary.common.CurrencyPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.CurrencyConversionModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        BindDemoLibraryModule::class,
        DemoModule::class,
        BindMainModule::class,
        ContextModule::class
    ]
)
interface ApplicationComponent  {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DemoApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: DemoApplication)
    fun inject(currencyPreference: CurrencyPreference)

    @VisibleForTesting
    fun getPreference(): CurrencyPreference
}