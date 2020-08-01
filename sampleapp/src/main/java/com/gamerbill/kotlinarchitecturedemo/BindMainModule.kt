package com.gamerbill.kotlinarchitecturedemo

import com.gamerbill.kotlinarchitecturedemo.demolibrary.common.CommonModule
import com.gamerbill.kotlinarchitecturedemo.demolibrary.dependencyinjectionscope.ActivityScope
import com.gamerbill.kotlinarchitecturedemo.demolibrary.dependencyinjectionscope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [CommonModule::class])
abstract class BindMainModule {
    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun bindDashboardFragment(): DashboardFragment
}