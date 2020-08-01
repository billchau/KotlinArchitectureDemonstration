package com.gamerbill.kotlinarchitecturedemo.demolibrary

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers

class RxUnitTestUtil  {
    companion object {
        @JvmStatic
        fun asyncToSync() {
            RxJavaPlugins.reset()
            RxAndroidPlugins.setInitMainThreadSchedulerHandler{ Schedulers.trampoline() }
            RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        }
    }
}