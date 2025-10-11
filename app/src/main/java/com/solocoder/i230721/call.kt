package com.solocoder.i230721

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class call : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.call_page)
        val endCallButton = findViewById<RelativeLayout>(R.id.endCallButton)
        endCallButton.setOnClickListener {
         val intent = Intent(this@call, chat::class.java)
            startActivity(intent)
            finish() // closes current activity
        }

    }
}