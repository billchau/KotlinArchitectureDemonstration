package com.gamerbill.kotlinarchitecturedemo.demolibrary.client.repository

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import com.gamerbill.kotlinarchitecturedemo.demolibrary.entity.GetClientResponse
import com.gamerbill.kotlinarchitecturedemo.demolibrary.entity.GetLoginResponse
import com.gamerbill.kotlinarchitecturedemo.demolibrary.entity.LoginBody
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.*

interface ClientApiService {
    @GET("/api/users")
    fun getClients(@QueryMap param: Map<String, String>) : Observable<GetClientResponse>

    @POST("/api/login")
    fun login(@Body body: LoginBody) : Observable<GetLoginResponse>
}

class ClientRepositoryImpl(private val clientApiService: ClientApiService): ClientRepository {
    override fun getClients(page: String): Observable<GetClientResponse> {
        val map = HashMap<String, String>()
        map.put("page", page)
        return clientApiService.getClients(map)
    }

    override fun login(client: Client): Observable<GetLoginResponse> {
        return clientApiService.login(LoginBody(client.email, client.fullName))
    }
}