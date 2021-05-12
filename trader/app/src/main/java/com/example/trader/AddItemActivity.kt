package com.example.trader

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.android.synthetic.main.activity_add_item.*
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.IOException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

class AddItemActivity : AppCompatActivity() {
    val itemClient = ItemAPI.create()
    var currentPath: String? = null
    val TAKE_PICTURE = 1
    val SELECT_PICTURE = 2
    var imageUrl: String? = ""
    var filePath: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        AndroidThreeTen.init(this)
        imageView.setOnClickListener {
            dispatchGalleryIntent()

        }

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "เพิ่มสินค้า"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == TAKE_PICTURE && resultCode == Activity.RESULT_OK){
//            try {
//                val file = File(currentPath)
//                val uri = Uri.fromFile(file)
//                imageView.setImageURI(uri)
//
//            }catch (e: IOException){
//                e.printStackTrace()
//            }
//        }
        if (requestCode == SELECT_PICTURE && resultCode == Activity.RESULT_OK && data !=null && data.data !=null){
            filePath = data.data
            try {
//                val uri = data!!.data
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imageView.setImageBitmap(bitmap)
//                imageText.text = bitmap.toString()
//
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, stream);
//                val byteArray:Byte = byteArrayOutputStream.toByteArray();
//                val ConvertImage:String = Base64.encodeToString(byteArray, Base64.DEFAULT);
//
//                imageText.text = bitmap.toString()

            }catch (e: IOException){
                e.printStackTrace()
            }
        }
    }
    fun dispatchGalleryIntent(){
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Image"), SELECT_PICTURE)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.post_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var token = getSharedPreferences("username", Context.MODE_PRIVATE)
        var token_username = token.getString("loginusername"," ")



        val localDateInBangkok = LocalDate.now(ZoneId.of("Asia/Bangkok"))
        val dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

        val localTimeInBangkok = LocalTime.now(ZoneId.of("Asia/Bangkok"))
        val timeformatter = DateTimeFormatter.ofPattern("HH:mm")

//        date_text.setText(localDateInBangkok.format(dateformatter))
//        time_text.setText(localTimeInBangkok.format(timeformatter))




        val id = item.itemId
        when (id) {
            R.id.item1 -> {
                itemClient.addItem(input_name.text.toString(),input_desc.text.toString(),input_desc.text.toString(),localDateInBangkok.format(dateformatter),localTimeInBangkok.format(timeformatter),filePath.toString(),token_username.toString()).enqueue(object : Callback<ItemDB> {


                    override fun onResponse(call: Call<ItemDB>, response: Response<ItemDB>) {
                        if(response.isSuccessful()){
                            Toast.makeText(applicationContext,"ลงสินค้าเรียบร้อยแล้ว",Toast.LENGTH_LONG).show()
                            finish()
                        }else{
                            Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<ItemDB>, t: Throwable) {
                        Toast.makeText(
                            applicationContext,
                            "Incorrect",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}