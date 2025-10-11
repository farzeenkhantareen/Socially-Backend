package com.solocoder.i230721

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Other_Person_Profile_follow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_other_person_profile_follow)
        val nav_home=findViewById<ImageView>(R.id.nav_home)
        nav_home.setOnClickListener {
            val intent = Intent(this, Main_feed::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }
        val nav_search=findViewById<ImageView>(R.id.nav_search)
        nav_search.setOnClickListener {
            val intent = Intent(this, Explore_page::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }
        val nav_heart=findViewById<ImageView>(R.id.nav_heart)
        nav_heart.setOnClickListener {
            val intent = Intent(this, Notification_You::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }
        val nav_profile=findViewById<ImageView>(R.id.nav_profile)
        nav_profile.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }
        val back_icon=findViewById<ImageView>(R.id.back_icon)
        back_icon.setOnClickListener {
            val intent = Intent(this, Main_feed::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }
        val follow_button=findViewById<Button>(R.id.follow_button)
        follow_button.setOnClickListener {
            val intent = Intent(this, Other_Person_Profile::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }

    }



}