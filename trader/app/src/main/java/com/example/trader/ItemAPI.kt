package com.example.trader

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import java.sql.Blob

interface ItemAPI {

    @GET("item")
    fun retrieveItem(): Call<List<ItemDB>>

    @FormUrlEncoded
    @POST("addItem")
    fun addItem(
        @Field("item_detail_name") item_detail_name: String,
        @Field("item_detail_description") item_detail_description: String,
        @Field("item_detail_change_by") item_detail_change_by: String,
        @Field("item_detail_date") item_detail_date: String,
        @Field("item_detail_time") item_detail_time: String,
        @Field("item_detail_img") item_detail_img: String,
        @Field("username") username: String): Call<ItemDB>


    companion object{
        fun create():ItemAPI{
            val itemClient:ItemAPI = Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ItemAPI::class.java)
            return itemClient
        }
    }

}


