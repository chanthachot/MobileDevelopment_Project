package com.example.trader

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPI {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("user_name") user_name: String,
        @Field("username") username: String,
        @Field("password") password: String): Call<UserDB>

    companion object {
        fun create(): UserAPI {
            val userClient: UserAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserAPI::class.java)
            return userClient
        }
    }

}