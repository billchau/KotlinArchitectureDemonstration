package com.gamerbill.kotlinarchitecturedemo.demolibrary

import android.content.Context
import com.gamerbill.kotlinarchitecturedemo.democontract.DemoConfig
import com.gamerbill.kotlinarchitecturedemo.democontract.DemoPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.repository.ClientApiService
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.repository.ClientRepository
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.repository.ClientRepositoryImpl
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.strategy.ClientStrategy
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.strategy.ClientStrategyContract
import com.gamerbill.kotlinarchitecturedemo.demolibrary.common.CurrencyPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.util.DateTimeUtil
import com.gamerbill.kotlinarchitecturedemo.demolibrary.util.DateTimeUtilImpl
import dagger.Module
import dagger.Provides

@Module
class DemoLibraryFramework {
    @Provides
    fun provideClientApiService(demoConfig: DemoConfig): ClientApiService {
        return demoConfig.demoRetrofit.create(ClientApiService::class.java)
    }

    @Provides
    fun provideClientRepository(apiService: ClientApiService): ClientRepository {
        return ClientRepositoryImpl(apiService)
    }

    @Provides
    fun provideClientStrategy(clientRepository: ClientRepository): ClientStrategyContract = ClientStrategy(clientRepository = clientRepository)

    @Provides
    fun provideDateTimeUtil(): DateTimeUtil = DateTimeUtilImpl()

    // you can definitely provide the implementation in sample app and expose to the outer world
    @Provides
    fun provideDemoPreference(context: Context): DemoPreference = CurrencyPreference(context)
}