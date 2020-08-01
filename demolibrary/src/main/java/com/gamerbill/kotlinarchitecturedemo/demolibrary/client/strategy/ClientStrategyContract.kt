package com.gamerbill.kotlinarchitecturedemo.demolibrary.client.strategy

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import io.reactivex.rxjava3.core.Observable

interface ClientStrategyContract {
    fun getClient(page: String): Observable<List<Client>>
    fun login(client: Client): Observable<String>
}