package com.gamerbill.kotlinarchitecturedemo.demolibrary

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.ClientDashboardContract
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.ClientDashboardPresenter
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.strategy.ClientStrategyContract
import com.gamerbill.kotlinarchitecturedemo.demolibrary.entity.GetClientResponse
import com.google.gson.annotations.SerializedName
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class ClientDashboardPresenterTest {
    @Mock
    lateinit var view: ClientDashboardContract.View

    lateinit var presenter: ClientDashboardContract.Presenter

    @Mock
    lateinit var clientStrategy: ClientStrategyContract

    @Before
    fun setup () {
        MockitoAnnotations.initMocks(this)
        RxUnitTestUtil.asyncToSync()
        presenter = ClientDashboardPresenter(clientStrategy)
        presenter.attachView(view)
    }

    @Test
    fun `test getClients updateResult` () {
        val clients = arrayListOf<Client>(
            Client().apply {
                id = 1
                email = "a@l.com"
                firstName = "first"
                lastName = "last"
                avatar = "http://avatar"
            }
        )
        `when`(clientStrategy.getClient("2")).thenReturn(
            Observable.just(
                clients
            )
        )
        presenter.getClients()
        verify(view).updateResult(clients)
    }

    @Test
    fun `test login loginResult` () {
        val client = Client().apply {
            id = 1
            email = "a@l.com"
            firstName = "first"
            lastName = "last"
            avatar = "http://avatar"
        }
        `when`(clientStrategy.login(client)).thenReturn(
            Observable.just(
                "testresult"
            )
        )
        presenter.login(client)
        verify(view).loginResult("testresult")
    }
}