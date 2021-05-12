package com.example.trader

import android.content.Intent
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val itemList = arrayListOf<ItemDB>()
    val itemClient = ItemAPI.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        floating_action_button.setOnClickListener(){
            val intent = Intent(applicationContext,AddItemActivity::class.java)
            startActivity(intent)
        }

        var token = getSharedPreferences("username", Context.MODE_PRIVATE)
        tv_username.text = token.getString("loginusername"," ")

        val actionbar = supportActionBar
        actionbar!!.title = "Trader"


        refreshlayout.setOnRefreshListener {
            Handler().postDelayed({
                callItemData()
            }, 2000)
        }
        refreshlayout.setColorSchemeColors(
            Color.parseColor("#d95c4c"))

        recycler_view.layoutManager = GridLayoutManager(this, 2)
        recycler_view.itemAnimator = DefaultItemAnimator() as RecyclerView.ItemAnimator?

        recycler_view.addOnItemTouchListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                val itemDetail = itemList[position]
                val intent = Intent(applicationContext, ItemDetailActivity::class.java)
                intent.putExtra("item_detail_id", itemDetail.item_detail_id.toString())
                intent.putExtra("item_detail_name", itemDetail.item_detail_name)
                intent.putExtra("item_detail_description", itemDetail.item_detail_description)
                intent.putExtra("item_detail_change_by", itemDetail.item_detail_change_by)
                intent.putExtra("item_detail_date", itemDetail.item_detail_date)
                intent.putExtra("item_detail_time", itemDetail.item_detail_time)
                intent.putExtra("item_detail_img", itemDetail.item_detail_img)
                intent.putExtra("user_id", itemDetail.user_id)
                intent.putExtra("user_name", itemDetail.user_name)
                intent.putExtra("username", itemDetail.username)
                intent.putExtra("password", itemDetail.user_name)
                intent.putExtra("line_id", itemDetail.line_id)
                startActivity(intent)
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var token = getSharedPreferences("username", Context.MODE_PRIVATE)
        when (item.itemId){
            R.id.nav_logout ->{
                var editor = token.edit()
                editor.putString("loginusername", " ")
                editor.commit()

                val intent = Intent(applicationContext,FirstActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

//
//    fun intent(v: View){
//        val intent = Intent(applicationContext, ItemDetailActivity::class.java)
//        startActivity(intent)
//
//    }

    override fun onResume() {
        super.onResume()
        callItemData()
    }


    fun callItemData() {
        refreshlayout.isRefreshing = true
        itemList.clear();
        itemClient.retrieveItem()
            .enqueue(object : Callback<List<ItemDB>> {
                override fun onResponse(
                    call: Call<List<ItemDB>>,
                    response: Response<List<ItemDB>>
                ) {   refreshlayout.isRefreshing = false
                    response.body()?.forEach {
                        itemList.add(ItemDB(it.item_detail_id, it.item_detail_name
                            , it.item_detail_description, it.item_detail_change_by, it.item_detail_date, it.item_detail_time, it.item_detail_img
                            , it.user_id , it.user_name , it.username , it.password, it.line_id))


                    }

                    recycler_view.adapter = ItemAdapter(itemList, applicationContext)
                }

                override fun onFailure(call: Call<List<ItemDB>>, t: Throwable) =
                    t.printStackTrace()
            })
    }

    interface OnItemClickListener {
        fun onItemClicked(position: Int, view: View)
    }
    fun RecyclerView.addOnItemTouchListener(onClickListener: OnItemClickListener) {
        this.addOnChildAttachStateChangeListener(object : RecyclerView.OnChildAttachStateChangeListener {

            override fun onChildViewDetachedFromWindow(view: View) {
                view?.setOnClickListener(null)
            }

            override fun onChildViewAttachedToWindow(view: View) {
                view?.setOnClickListener {
                    val holder = getChildViewHolder(view)
                    onClickListener.onItemClicked(holder.adapterPosition, view)
                }
            }
        })
    }
}

