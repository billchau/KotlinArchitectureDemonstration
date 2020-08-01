package com.gamerbill.kotlinarchitecturedemo.demolibrary.client

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client

interface ClientDashboardContract {
    interface View {
        fun updateResult(client: List<Client>)
        fun loginResult(result: String)
    }

    interface Presenter {
        fun attachView(view: View?)
        fun detachView()
        fun getClients()
        fun login(client: Client)
    }
}