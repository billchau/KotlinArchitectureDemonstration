package com.gamerbill.kotlinarchitecturedemo.demolibrary

import com.gamerbill.kotlinarchitecturedemo.democontract.DemoPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.common.CurrencyPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.CurrencyConversionContract
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.CurrencyConversionPresenter
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class CurrencyConversionPresenterTest {
    @Mock
    lateinit var view: CurrencyConversionContract.View

    lateinit var presenter: CurrencyConversionContract.Presenter

    @Mock
    lateinit var currencyPreference: DemoPreference

    @Before
    fun setup () {
        MockitoAnnotations.initMocks(this)
        presenter = CurrencyConversionPresenter(currencyPreference)
        presenter.attachView(view)
    }

    @Test
    fun testCalculate() {
        `when`(currencyPreference.rateUsd).thenReturn(1f)
        `when`(currencyPreference.rateHkd).thenReturn(7.8f)
        presenter.calculate("USD", "HKD", "10")
        verify(view).updateResult("78.00")
    }
}