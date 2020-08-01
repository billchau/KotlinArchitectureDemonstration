package com.gamerbill.kotlinarchitecturedemo.demolibrary.networking

import okhttp3.HttpUrl

interface RequestParameter {
    fun append(builder: HttpUrl.Builder)
}

interface DefaultRequestParameter : RequestParameter{
    val parameter: Map<String, String>
    override fun append(builder: HttpUrl.Builder) {
        for (key in parameter.keys) {
            builder.addQueryParameter(key, parameter.get(key))
        }
    }
}

class GetClientParameter(val page: String) : DefaultRequestParameter {
    override val parameter: Map<String, String>
        get() = mapOf("page" to page)
}