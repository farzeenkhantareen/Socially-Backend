package com.solocoder.i230721

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Sign_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sign_up)

        val backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            val intent = Intent(this@Sign_up, Login_Page::class.java)
            startActivity(intent)
            finish()
        }

        val createAccountBtn = findViewById<Button>(R.id.createAccountBtn)
        createAccountBtn.setOnClickListener {
            val intent = Intent(this@Sign_up, Login_Username_Password::class.java)
            startActivity(intent)
            finish()
        }
    }
}