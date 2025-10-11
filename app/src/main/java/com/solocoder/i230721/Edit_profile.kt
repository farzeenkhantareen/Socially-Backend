package com.solocoder.i230721

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Edit_profile : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile)
        val done_btn=findViewById<TextView>(R.id.done_btn)
        done_btn.setOnClickListener {
          val Intent= Intent(this, Profile::class.java)
            startActivity(Intent)
            finish()
        }
        val cancel_btn=findViewById<TextView>(R.id.cancel_btn)
        cancel_btn.setOnClickListener {
            val Intent= Intent(this, Profile::class.java)
            startActivity(Intent)
            finish()
        }


    }
}