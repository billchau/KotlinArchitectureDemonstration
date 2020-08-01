package com.gamerbill.kotlinarchitecturedemo.demolibrary.client

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import com.gamerbill.kotlinarchitecturedemo.demolibrary.client.strategy.ClientStrategyContract

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ClientDashboardPresenter(private val clientStrategy: ClientStrategyContract) :
    ClientDashboardContract.Presenter {
    var view: ClientDashboardContract.View? = null
    val compositeDisposable = CompositeDisposable()
    override fun attachView(view: ClientDashboardContract.View?) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun getClients() {
        val disposable = clientStrategy.getClient("2")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view?.updateResult(it)
            }
        compositeDisposable.add(disposable)
    }

    override fun login(client: Client) {
        val disposable = clientStrategy.login(client)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view?.loginResult(it)
            }
        compositeDisposable.add(disposable)
    }
}