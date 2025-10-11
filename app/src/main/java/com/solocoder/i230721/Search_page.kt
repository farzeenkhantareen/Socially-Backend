package com.solocoder.i230721

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Search_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.search_page)
val clear_button=findViewById<ImageView>(R.id.clear_button)
        clear_button.setOnClickListener {
            val Intent= Intent(this, Explore_page::class.java)
            startActivity(Intent)
           finish()
        }

    }
}