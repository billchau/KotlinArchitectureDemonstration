package com.gamerbill.kotlinarchitecturedemo.demolibrary.entity

import com.gamerbill.kotlinarchitecturedemo.democontract.model.Client
import com.google.gson.annotations.SerializedName
import retrofit2.http.Header

data class GetClientResponse(
    @SerializedName("page") val page: Number,
    @SerializedName("per_page") val perPage: Number,
    @SerializedName("total") val total: Number,
    @SerializedName("total_pages") val totalPages: Number,
    @SerializedName("data") val clients: List<ClientResponseInfo>
) {
    data class ClientResponseInfo(
        @SerializedName("id") val id: Number,
        @SerializedName("email") val email: String,
        @SerializedName("first_name") val firstName: String,
        @SerializedName("last_name") val lastName: String,
        @SerializedName("avatar") val avatar: String
    )
}

data class GetLoginResponse(
    @SerializedName("token") val token: String
)
