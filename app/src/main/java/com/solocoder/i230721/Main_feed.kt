package com.solocoder.i230721

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Main_feed : AppCompatActivity() {
    private val CAMERA_REQUEST_CODE = 101
    private lateinit var cameraIcon: ImageView
    private lateinit var capturedImage: ImageView
    val GALLERY_REQUEST_CODE = 300
    private lateinit var previewImage: ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.main_feed)

        val top_share = findViewById<ImageView>(R.id.top_share)
        top_share.setOnClickListener {
            val intent = Intent(this, dm_page::class.java)
            startActivity(intent)   // <-- missing line
        }

        val nav_search=findViewById<ImageView>(R.id.nav_search)
        nav_search.setOnClickListener {
            val intent = Intent(this, Explore_page::class.java)
            startActivity(intent)   // <-- missing line
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
        }
        val profile_pic1=findViewById<ImageView>(R.id.profile_pic1)
        profile_pic1.setOnClickListener {
            val intent = Intent(this, Other_Person_Profile_follow::class.java)
            startActivity(intent)   // <-- missing line
            finish()

        }
        val username=findViewById<TextView>(R.id.username)
        username.setOnClickListener {
            val intent = Intent(this, Other_Person_Profile_follow::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }
        val story=findViewById<ImageView>(R.id.story)
        story.setOnClickListener {
            val intent = Intent(this, Edit_Story::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }

val story_setup=findViewById<LinearLayout>(R.id.story_setup)
        story_setup.setOnClickListener {
            val intent = Intent(this, Friend_Story::class.java)
            startActivity(intent)   // <-- missing line
            finish()
        }
        cameraIcon=findViewById(R.id.camera)
        capturedImage=findViewById(R.id.captured_image)
        cameraIcon.setOnClickListener {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,CAMERA_REQUEST_CODE)
        }
        val nav_reel=findViewById<ImageView>(R.id.nav_reel)
        previewImage = findViewById(R.id.previewImage)
        nav_reel.setOnClickListener {
            openGallery()
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val photo: Bitmap = data?.extras?.get("data") as Bitmap
            capturedImage.setImageBitmap(photo) // display image
        }
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val selectedImageUri: Uri? = data?.data
            previewImage.setImageURI(selectedImageUri)
        }
    }

}

private fun Main_feed.openGallery() {
    val intent = Intent(Intent.ACTION_PICK)
    intent.type = "image/*"
    startActivityForResult(intent, GALLERY_REQUEST_CODE)
}
