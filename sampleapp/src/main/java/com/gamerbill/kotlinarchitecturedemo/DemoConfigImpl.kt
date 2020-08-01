package com.gamerbill.kotlinarchitecturedemo

import com.gamerbill.kotlinarchitecturedemo.democontract.DemoConfig
import retrofit2.Retrofit

class DemoConfigImpl(override val demoRetrofit: Retrofit): DemoConfig