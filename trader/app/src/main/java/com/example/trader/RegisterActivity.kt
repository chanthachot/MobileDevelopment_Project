package com.example.trader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback

class RegisterActivity : AppCompatActivity() {
    val userClient = UserAPI.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val close_btn_register: ImageView
        close_btn_register = findViewById<View>(R.id.close_btn_register) as ImageView
        close_btn_register.setOnClickListener () {
            finish()

        }



        btnRegister.setOnClickListener(){
            userClient.register(reg_name.text.toString(),
                reg_username.text.toString(),
                reg_password.text.toString()).enqueue(object : Callback<UserDB> {

                override fun onResponse(call: Call<UserDB>, response: retrofit2.Response<UserDB>) {
                    if (response.isSuccessful()) {
                        Toast.makeText(applicationContext,"Successfully Register", Toast.LENGTH_SHORT).show()
                        finish()
                    }else{
                        Toast.makeText(applicationContext,"Error ", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<UserDB>, t: Throwable) {
                    Toast.makeText(applicationContext,"Register Fail" + t.message,
                        Toast.LENGTH_LONG).show()

                }

            })
        }
    }
}
