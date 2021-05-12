package com.example.trader

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Blob

data class ItemDB (

    @Expose
    @SerializedName("item_detail_id") val item_detail_id: Int,

    @Expose
    @SerializedName("item_detail_name") val item_detail_name: String,

    @Expose
    @SerializedName("item_detail_description") val item_detail_description: String,

    @Expose
    @SerializedName("item_detail_change_by") val item_detail_change_by: String,

    @Expose
    @SerializedName("item_detail_date") val item_detail_date: String,

    @Expose
    @SerializedName("item_detail_time") val item_detail_time: String,

    @Expose
    @SerializedName("item_detail_img") val item_detail_img: String,

    @Expose
    @SerializedName("user_id") val user_id: Int,

    @Expose
    @SerializedName("user_name") val user_name: String,

    @Expose
    @SerializedName("username") val username: String,

    @Expose
    @SerializedName("password") val password: String,

    @Expose
    @SerializedName("line_id") val line_id: String) {
}