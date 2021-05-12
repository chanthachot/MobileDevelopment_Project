package com.example.trader

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        var token = getSharedPreferences("username" , Context.MODE_PRIVATE)
        if(token.getString("loginusername"," ") !=" "){
            var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        btn_goLog.setOnClickListener(){
            var intent = Intent(applicationContext,LoginActivity::class.java)
            startActivity(intent)
        }

        btn_goReg.setOnClickListener(){
            var intent = Intent(applicationContext,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
