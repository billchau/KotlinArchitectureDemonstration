package com.gamerbill.kotlinarchitecturedemo.demolibrary.common

import android.content.Context
import android.content.SharedPreferences
import com.gamerbill.kotlinarchitecturedemo.democontract.DemoPreference
import com.gamerbill.kotlinarchitecturedemo.demolibrary.R
import org.json.JSONObject

open class CurrencyPreference (private val context: Context): DemoPreference {
    lateinit var rateJson: JSONObject
    init {
        val fileInString: String = context.resources.openRawResource(R.raw.exchange_rate).bufferedReader().readText()
        println(fileInString)
        rateJson = JSONObject(fileInString)
        println(rateJson)
    }
    private fun getSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(PREF_KEY, Context.MODE_PRIVATE)
    }

    override var rateJpy: Float
        get() = getSharedPreference().getFloat(PREF_KEY_JPY, rateJson.getDouble(JSON_KEY_JPY).toFloat())
        set(value) = getSharedPreference().edit().putFloat(PREF_KEY_JPY, value).apply()

    override var rateUsd: Float
        get() = getSharedPreference().getFloat(PREF_KEY_USD, rateJson.getDouble(JSON_KEY_USD).toFloat())
        set(value) = getSharedPreference().edit().putFloat(PREF_KEY_USD, value).apply()

    override var rateHkd: Float
        get() = getSharedPreference().getFloat(PREF_KEY_HKD, rateJson.getDouble(JSON_KEY_HKD).toFloat())
        set(value) = getSharedPreference().edit().putFloat(PREF_KEY_HKD, value).apply()

    override var rateRmb: Float
        get() = getSharedPreference().getFloat(PREF_KEY_RMB, rateJson.getDouble(JSON_KEY_RMB).toFloat())
        set(value) = getSharedPreference().edit().putFloat(PREF_KEY_RMB, value).apply()

    companion object {
        private const val PREF_KEY = "CURRENCY_PREF"
        private const val PREF_KEY_JPY = "PREF_KEY_JPY"
        private const val PREF_KEY_USD = "PREF_KEY_USD"
        private const val PREF_KEY_HKD = "PREF_KEY_HKD"
        private const val PREF_KEY_RMB = "PREF_KEY_RMB"
    // default value in json
         const val JSON_KEY_JPY = "JPY"
         const val JSON_KEY_USD = "USD"
         const val JSON_KEY_HKD = "HKD"
         const val JSON_KEY_RMB = "RMB"
    }
}