package com.gamerbill.kotlinarchitecturedemo.democontract

import androidx.fragment.app.Fragment

interface DemoFeature {
    fun getCurrencyConversionFragment(): Fragment
    fun getClientDashboard(): Fragment
}