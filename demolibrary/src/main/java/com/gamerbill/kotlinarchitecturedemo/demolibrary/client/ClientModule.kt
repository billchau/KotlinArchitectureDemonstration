package com.gamerbill.kotlinarchitecturedemo.demolibrary.client

import com.gamerbill.kotlinarchitecturedemo.demolibrary.DemoLibraryFramework
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.strategy.ClientStrategyContract
import dagger.Module
import dagger.Provides

@Module(includes = [DemoLibraryFramework::class])
class ClientModule {
    @Provides
    fun provideClientDashboardPresenter(clientStrategy: ClientStrategyContract) : ClientDashboardContract.Presenter = ClientDashboardPresenter(clientStrategy)
}