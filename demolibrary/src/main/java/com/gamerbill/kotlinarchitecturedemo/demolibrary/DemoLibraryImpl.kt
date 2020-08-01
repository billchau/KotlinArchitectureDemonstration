package com.gamerbill.kotlinarchitecturedemo.demolibrary

import androidx.fragment.app.Fragment
import com.gamerbill.kotlinarchitecturedemo.democontract.DemoFeature
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.ClientDashboardFragment
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.CurrencyConversionFragment

class DemoLibraryImpl(): DemoFeature {
    override fun getCurrencyConversionFragment(): Fragment {
        return CurrencyConversionFragment.newInstance()
    }

    override fun getClientDashboard(): Fragment {
        return ClientDashboardFragment.newInstance()
    }
}