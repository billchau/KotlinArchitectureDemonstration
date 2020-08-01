package com.gamerbill.kotlinarchitecturedemo

import android.app.Application
import androidx.annotation.VisibleForTesting
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DemoApplication : Application(), HasAndroidInjector {

    lateinit var appComponent: ApplicationComponent

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }

    @VisibleForTesting
    fun getApplicationComponent(): ApplicationComponent {
        return appComponent
    }
}
