package com.gamerbill.kotlinarchitecturedemo.democontract.model

import com.google.gson.annotations.SerializedName

class Client {
    var id: Number = 0
    var email: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var avatar: String = ""

    var fullName: String = ""
        get() = "$firstName $lastName"
}