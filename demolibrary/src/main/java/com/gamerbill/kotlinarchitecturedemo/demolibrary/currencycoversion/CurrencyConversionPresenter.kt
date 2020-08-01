package com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion

import com.gamerbill.kotlinarchitecturedemo.democontract.DemoPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.common.CurrencyPreference

class CurrencyConversionPresenter(private val currencyPreference: DemoPreference): CurrencyConversionContract.Presenter {
    var view: CurrencyConversionContract.View? = null
    override fun attachView(view: CurrencyConversionContract.View?) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun calculate(fromCurrency: String, toCurrency: String, amount: String) {
        val fromRate = getRate(fromCurrency)
        val toRate = getRate(toCurrency)
        val result = amount.toDouble() * toRate / fromRate
        view?.updateResult(String.format("%.2f", result))
    }

    private fun getRate (currency: String): Float {
        return when (currency) {
            CurrencyPreference.JSON_KEY_JPY -> currencyPreference.rateJpy
            CurrencyPreference.JSON_KEY_USD -> currencyPreference.rateUsd
            CurrencyPreference.JSON_KEY_RMB -> currencyPreference.rateRmb
            else -> currencyPreference.rateHkd
        }
    }
}