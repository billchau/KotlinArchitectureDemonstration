package com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader

interface CurrencyHeaderContract {
    interface View{
        fun displayMorningMessage()
        fun displayAfternoonMessage()
        fun displayNightMessage()
    }

    interface Presenter {
        fun attachView(view: View?)
        fun detachView()
        fun showTitleMessage()
    }
}