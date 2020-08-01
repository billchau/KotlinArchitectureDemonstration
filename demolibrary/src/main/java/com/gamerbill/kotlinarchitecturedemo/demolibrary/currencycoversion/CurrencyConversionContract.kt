package com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion

interface CurrencyConversionContract {
    interface View{
        fun updateResult(result: String)
    }

    interface Presenter {
        fun attachView(view: View?)
        fun detachView()
        fun calculate(fromCurrency: String, toCurrency: String, amount: String)
    }
}