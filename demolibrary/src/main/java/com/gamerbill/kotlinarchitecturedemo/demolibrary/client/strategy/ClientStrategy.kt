package com.gamerbill.kotlinarchitecturedemo.demolibrary.client.strategy

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.repository.ClientRepository
import io.reactivex.rxjava3.core.Observable

class ClientStrategy(private val clientRepository: ClientRepository) : ClientStrategyContract {
    // otherwise, just implement the
    override fun getClient(page: String): Observable<List<Client>> {
        // you may add more logic about the api here
        // i.e. how to handle response, how to handle request, performing chained request
        return clientRepository.getClients(page)
            .map {
                var clients = arrayListOf<Client>()
                for (customerInfo in it.clients) {
                    clients.add(Client().apply {
                        id = customerInfo.id
                        email = customerInfo.email
                        firstName = customerInfo.firstName
                        lastName = customerInfo.lastName
                        avatar = customerInfo.avatar
                    })
                }
                clients
            }
    }

    override fun login(client: Client): Observable<String> {
        return clientRepository.login(client)
            .map {
                it.token
            }
    }
}