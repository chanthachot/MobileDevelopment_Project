package com.example.trader

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_detail.*


class ItemDetailActivity : AppCompatActivity() {
    val itemList = arrayListOf<ItemDB>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        var token = getSharedPreferences("username", Context.MODE_PRIVATE)
        var token_username = token.getString("loginusername", " ")
        val item_detail_name = intent.getStringExtra("item_detail_name")
        val item_detail_description = intent.getStringExtra("item_detail_description")
        val item_detail_change_by = intent.getStringExtra("item_detail_change_by")
        val item_detail_date = intent.getStringExtra("item_detail_date")
        val item_detail_time = intent.getStringExtra("item_detail_time")
        var item_detail_img = intent.getStringExtra("item_detail_img")
        val username = intent.getStringExtra("username")
        val user_name = intent.getStringExtra("user_name")
        val line_id = intent.getStringExtra("line_id")



        if (token_username == username) {
            want.visibility = View.GONE
        } else {

            want.visibility = View.VISIBLE
        }



        want.setOnClickListener() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("สนใจสินค้า")

            // Display a message on alert dialog
            builder.setMessage("ติดต่อ Line Id: " + line_id)


            // Display a neutral button on alert dialog
            builder.setNeutralButton("Cancel") { _, _ ->
                Toast.makeText(applicationContext, "You cancelled the dialog.", Toast.LENGTH_SHORT)
                    .show()
            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()
        }


//        tv_test_username.setText(item_detail_img)


        val image: ImageView
        image = findViewById<View>(R.id.image_detail) as ImageView
        Glide.with(this)
            .load(item_detail_img)
            .into(image)
//        Picasso.with(this).load(item_detail_img).into(image)

        image.setOnClickListener () {
                val intent = Intent(applicationContext, ViewImageActivity::class.java)
                intent.putExtra("item_detail_img", item_detail_img)
                startActivity(intent)
        }

        tv_detail_user_name.setText(user_name)
        tv_detail_desc.setText(item_detail_description)
        tv_detail_date.setText(item_detail_date)
        tv_detail_time.setText(item_detail_time)
        tv_detail_change_by.setText(item_detail_change_by)


        val actionbar = supportActionBar
        actionbar!!.title = item_detail_name

        actionbar.setDisplayHomeAsUpEnabled(true)



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    }


