package com.solocoder.i230721

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class chat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.chat_screen)

        val back_arrow = findViewById<ImageView>(R.id.back_arrow)
        back_arrow.setOnClickListener {
            val intent = Intent(this@chat, dm_page::class.java)
            startActivity(intent)
            finish() // closes current activity
        }
        val video_call=findViewById<ImageView>(R.id.video_call)
        video_call.setOnClickListener {
            val intent = Intent(this@chat, call::class.java)
            startActivity(intent)
            finish() // closes current activity
        }
    }
}
