package com.solocoder.i230721

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Profile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        var nav_home=findViewById<ImageView>(R.id.nav_home)
        nav_home.setOnClickListener {
            val Intent = Intent(this, Main_feed::class.java)
            startActivity(Intent)
            finish()
        }
        var nav_search=findViewById<ImageView>(R.id.nav_search)
        nav_search.setOnClickListener {
            val Intent = Intent(this, Explore_page::class.java)
            startActivity(Intent)
            finish()
        }
        var nav_heart=findViewById<ImageView>(R.id.nav_heart)
        nav_heart.setOnClickListener {
            val Intent = Intent(this, Notification_You::class.java)
            startActivity(Intent)
            finish()
        }

        val edit_page=findViewById<RelativeLayout>(R.id.edit_page)
        edit_page.setOnClickListener {
            val Intent = Intent(this, Edit_profile::class.java)
            startActivity(Intent)
            finish()
        }
        val friends_highlight=findViewById<RelativeLayout>(R.id.friends_highlight)
        friends_highlight.setOnClickListener {
            val Intent = Intent(this, Highlight::class.java)
            startActivity(Intent)
            finish()
        }



    }
}