package com.solocoder.i230721

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Edit_Story : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_story)
        val close_button=findViewById<ImageView>(R.id.close_button)
        close_button.setOnClickListener {
            val Intent= Intent(this, Main_feed::class.java)
            startActivity(Intent)
            finish()
        }

        val bottom_navigation=findViewById<RelativeLayout>(R.id.bottom_navigation)
        bottom_navigation.setOnClickListener {
            val Intent= Intent(this, Story::class.java)
            startActivity(Intent)
            finish()
        }
    }
}