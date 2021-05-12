package com.example.trader

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserDB (
    @Expose
    @SerializedName("user_id") val user_id: Int,

    @Expose
    @SerializedName("user_name") val user_name: String,

    @Expose
    @SerializedName("username") val username: String,

    @Expose
    @SerializedName("password") val password: String) {
}