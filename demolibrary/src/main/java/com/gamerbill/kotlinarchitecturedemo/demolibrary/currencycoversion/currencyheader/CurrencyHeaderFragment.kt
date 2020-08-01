package com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gamerbill.kotlinarchitecturedemo.demolibrary.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_currency_header.*
import javax.inject.Inject

class CurrencyHeaderFragment: Fragment(), CurrencyHeaderContract.View {
    @Inject
    lateinit var presenter: CurrencyHeaderContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currency_header, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.showTitleMessage()
    }

    override fun displayMorningMessage() {
        tvHeader.text = "Good morning"
    }

    override fun displayAfternoonMessage() {
        tvHeader.text = "Good afternoon"
    }

    override fun displayNightMessage() {
        tvHeader.text = "Good evening"
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    companion object {
        fun newInstance () = CurrencyHeaderFragment()
    }
}