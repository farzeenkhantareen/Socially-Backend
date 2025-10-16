package com.solocoder.i230721

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import de.hdodenhof.circleimageview.CircleImageView

class Profile : AppCompatActivity() {

    private lateinit var profilePicture: CircleImageView
    private lateinit var database: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        profilePicture = findViewById(R.id.profile_picture)

        val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return
        database = FirebaseDatabase.getInstance().getReference("Users").child(uid)

        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val base64String = snapshot.child("image").getValue(String::class.java)
                if (!base64String.isNullOrEmpty()) {
                    try {
                        val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
                        val decodedBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                        profilePicture.setImageBitmap(decodedBitmap)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })

        findViewById<ImageView>(R.id.nav_home).setOnClickListener {
            startActivity(Intent(this, Main_feed::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.nav_search).setOnClickListener {
            startActivity(Intent(this, Explore_page::class.java))
            finish()
        }

        findViewById<ImageView>(R.id.nav_heart).setOnClickListener {
            startActivity(Intent(this, Notification_You::class.java))
            finish()
        }

        findViewById<RelativeLayout>(R.id.edit_page).setOnClickListener {
            startActivity(Intent(this, Edit_profile::class.java))
            finish()
        }

        findViewById<RelativeLayout>(R.id.friends_highlight).setOnClickListener {
            startActivity(Intent(this, Highlight::class.java))
            finish()
        }
    }
}
