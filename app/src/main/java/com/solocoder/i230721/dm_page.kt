package com.solocoder.i230721

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class dm_page : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 101
    private lateinit var cameraIcon: ImageView
    private lateinit var capturedImage1: ImageView
    @SuppressLint("SuspiciousIndentation", "WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.dm_page)
    var backButton=findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            val intent: Intent = Intent(this@dm_page, Main_feed::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        }
        var chat1=findViewById<RelativeLayout>(R.id.chat1)
        chat1.setOnClickListener {
            val intent: Intent = Intent(this@dm_page, chat::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        }
        var chat2=findViewById<RelativeLayout>(R.id.chat2)
        chat2.setOnClickListener {
            val intent: Intent = Intent(this@dm_page, chat::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        }
        var chat3=findViewById<RelativeLayout>(R.id.chat3)
        chat3.setOnClickListener {
            val intent: Intent = Intent(this@dm_page, chat::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        }
        var chat4=findViewById<RelativeLayout>(R.id.chat4)
        chat4.setOnClickListener {
            val intent: Intent = Intent(this@dm_page, chat::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        }
        var chat5=findViewById<RelativeLayout>(R.id.chat5)
        chat5.setOnClickListener {
            val intent: Intent = Intent(this@dm_page, chat::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        }
        var chat6=findViewById<RelativeLayout>(R.id.chat6)
        chat6.setOnClickListener {
            val intent: Intent = Intent(this@dm_page, chat::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        }

        cameraIcon = findViewById(R.id.cameraIcon)
        capturedImage1 = findViewById(R.id.capturedImage)  // initialize ✅

        cameraIcon.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_REQUEST_CODE)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val photo: Bitmap = data?.extras?.get("data") as Bitmap
            capturedImage1.setImageBitmap(photo) // works now ✅
        }
    }
}
