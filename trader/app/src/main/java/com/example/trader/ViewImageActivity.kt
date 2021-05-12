package com.example.trader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ViewImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)


        val close_btn: ImageView
        close_btn = findViewById<View>(R.id.close_btn) as ImageView
        close_btn.setOnClickListener () {
            finish()

        }

        val close_view: ImageView
        close_view = findViewById<View>(R.id.full_image_view) as ImageView
        close_view.setOnClickListener () {
            finish()

        }

        var item_detail_img = intent.getStringExtra("item_detail_img")
        val full_image_view: ImageView
        full_image_view = findViewById<View>(R.id.full_image_view) as ImageView
        Picasso.get().load(item_detail_img).into(full_image_view)


    }
}
