package com.gamerbill.kotlinarchitecturedemo.demolibrary

import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader.CurrencyHeaderContract
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader.CurrencyHeaderPresenter
import com.gamerbill.kotlinarchitecturedemo.demolibrary.util.DateTimeUtil
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.*

class CurrencyHeaderPresenterTest {
    @Mock
    lateinit var view: CurrencyHeaderContract.View

    lateinit var presenter: CurrencyHeaderContract.Presenter

    @Mock
    lateinit var dateTimeUtil: DateTimeUtil

    @Before
    fun setup () {
        MockitoAnnotations.initMocks(this)
        presenter = CurrencyHeaderPresenter(dateTimeUtil)
        presenter.attachView(view)
    }

    @Test
    fun `test showTitleMessage displayMorningMessage` () {
        `when`(dateTimeUtil.getHour()).thenReturn(7)
        presenter.showTitleMessage()
        verify(view).displayMorningMessage()
    }

    @Test
    fun `test showTitleMessage displayAfternoonMessage` () {
        `when`(dateTimeUtil.getHour()).thenReturn(13)
        presenter.showTitleMessage()
        verify(view).displayAfternoonMessage()
    }

    @Test
    fun `test showTitleMessage displayNightMessage` () {
        `when`(dateTimeUtil.getHour()).thenReturn(18)
        presenter.showTitleMessage()
        verify(view).displayNightMessage()
    }
}