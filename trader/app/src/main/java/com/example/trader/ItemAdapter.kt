package com.example.trader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemAdapter (val item : List<ItemDB>, val context: Context): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view_item)
    }

    override fun getItemCount(): Int {
        return item.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_item_name?.text = item[position].item_detail_name
        holder.tv_user_name?.text = item[position].user_name
        Glide.with(context)
            .load(item[position].item_detail_img)
            .into(holder.iv_image)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_item_name = view.tv_item_name
        val tv_user_name = view.tv_user_name
        val iv_image = view.iv_image
    }
}