package com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader

import com.gamerbill.kotlinarchitecturedemo.demolibrary.util.DateTimeUtil
import java.util.*
import javax.inject.Inject

class CurrencyHeaderPresenter(private val dateTimeUtil: DateTimeUtil) : CurrencyHeaderContract.Presenter {
    private var view: CurrencyHeaderContract.View? = null
    override fun attachView(view: CurrencyHeaderContract.View?) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun showTitleMessage() {
        val hour = dateTimeUtil.getHour()
        when {
            hour < 6 -> view?.displayNightMessage()
            hour < 12 -> view?.displayMorningMessage()
            hour < 18 -> view?.displayAfternoonMessage()
            else -> view?.displayNightMessage()
        }
    }
}