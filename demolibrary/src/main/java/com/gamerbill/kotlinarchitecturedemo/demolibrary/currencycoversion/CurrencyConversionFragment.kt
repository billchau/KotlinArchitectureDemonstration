package com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.gamerbill.kotlinarchitecturedemo.demolibrary.R
import com.gamerbill.kotlinarchitecturedemo.demolibrary.currencycoversion.currencyheader.CurrencyHeaderFragment
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_currency_conversion.*
import javax.inject.Inject

class CurrencyConversionFragment : Fragment(), CurrencyConversionContract.View {
    @Inject
    lateinit var presenter: CurrencyConversionContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currency_conversion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView () {
        childFragmentManager.beginTransaction()
            .replace(R.id.currencyHeaderContainer, CurrencyHeaderFragment.newInstance())
            .commit()

        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.currency))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFromCurrency.adapter = adapter
        spinnerFromCurrency.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // either one will work as well
                // val item = parent.getItemAtPosition(position) as String
                val item = adapter.getItem(position)
            }
        }
        spinnerToCurrency.adapter = adapter
        spinnerToCurrency.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // either one will work as well
                // val item = parent.getItemAtPosition(position) as String
                val item = adapter.getItem(position)
            }
        }

        btnSwap.setOnClickListener {
            val tempIndex = spinnerFromCurrency.selectedItemPosition
            spinnerFromCurrency.setSelection(spinnerToCurrency.selectedItemPosition)
            spinnerToCurrency.setSelection(tempIndex)
        }

        btnCalculate.setOnClickListener {
            presenter.calculate(spinnerFromCurrency.selectedItem as String, spinnerToCurrency.selectedItem as String, etInputFromAmount.text.toString())
        }
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

    override fun updateResult(result: String) {
        etInputToAmount.setText(result)
    }

    // for fragment creation, put param if needed
    companion object {
        fun newInstance() = CurrencyConversionFragment()
    }
}