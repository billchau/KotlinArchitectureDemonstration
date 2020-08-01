package com.gamerbill.kotlinarchitecturedemo

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

// provides global application and context (use DemoApplication, not Application)
@Module
abstract class ContextModule {
    @Singleton
    @Binds
    abstract fun application (appInstance: DemoApplication): Application

    @Singleton
    @Binds
    abstract fun context (appInstance: DemoApplication): Context
}