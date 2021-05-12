package com.example.trader

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    val userClient = UserAPI.create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val close_btn_login: ImageView
        close_btn_login = findViewById<View>(R.id.close_btn_login) as ImageView
        close_btn_login.setOnClickListener () {
            finish()

        }


        var token = getSharedPreferences("username" , Context.MODE_PRIVATE)


        clickRegister.setOnClickListener(){
            var intent = Intent(applicationContext,RegisterActivity::class.java)
            startActivity(intent)
        }

    btnLogin.setOnClickListener(){
        userClient.login(log_username.text.toString(),
            log_password.text.toString()).enqueue(object : Callback<UserDB>{

            override fun onResponse(call: Call<UserDB>, response: Response<UserDB>) {
                if (response.isSuccessful()){

                    var username = log_username.text.toString()
                    var intent = Intent(applicationContext,MainActivity::class.java)
                    intent.putExtra("username",username)

                    var editor = token.edit()
                    editor.putString("loginusername",username)
                    editor.commit()
                        startActivity(intent)
                }else{
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserDB>, t: Throwable) {
                Toast.makeText(applicationContext,"Incorrect Username/Password",Toast.LENGTH_LONG).show()
            }

        })

    }

}
}
