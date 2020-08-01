package com.gamerbill.kotlinarchitecturedemo.demolibrary.client.repository

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import com.gamerbill.kotlinarchitecturedemo.demolibrary.entity.GetClientResponse
import com.gamerbill.kotlinarchitecturedemo.demolibrary.entity.GetLoginResponse
import io.reactivex.rxjava3.core.Observable

interface ClientRepository {
    fun getClients(page: String): Observable<GetClientResponse>
    fun login(client: Client): Observable<GetLoginResponse>
}