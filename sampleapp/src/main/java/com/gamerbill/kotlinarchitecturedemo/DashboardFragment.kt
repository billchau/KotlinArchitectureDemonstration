package com.gamerbill.kotlinarchitecturedemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gamerbill.kotlinarchitecturedemo.democontract.DemoFeature
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject

class DashboardFragment : Fragment() {
    @Inject
    lateinit var demoFeature: DemoFeature

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init ()
    }

    private fun init () {
        currencyConversionBtn.setOnClickListener {
            val fragment = demoFeature.getCurrencyConversionFragment()

            fragment.retainInstance = true
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.content, fragment)?.addToBackStack(fragment.tag)?.commit()
        }

        clientListBtn.setOnClickListener {
            val fragment = demoFeature.getClientDashboard()
            fragment.retainInstance = true
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.content, fragment)?.addToBackStack(fragment.tag)?.commit()
        }
    }
}