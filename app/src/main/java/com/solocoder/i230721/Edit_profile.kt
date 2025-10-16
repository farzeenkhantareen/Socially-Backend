package com.solocoder.i230721

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.io.ByteArrayOutputStream

class Edit_profile : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private val CAMERA_REQUEST_CODE = 101
    private val GALLERY_REQUEST_CODE = 300
    private var imageString: String? = null

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile)

        profileImage = findViewById(R.id.profile_image)
        val done_btn = findViewById<TextView>(R.id.done_btn)
        val cancel_btn = findViewById<TextView>(R.id.cancel_btn)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        loadProfileImage()

        profileImage.setOnClickListener {
            val pickIntent = Intent(Intent.ACTION_PICK)
            pickIntent.type = "image/*"
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            val chooser = Intent.createChooser(pickIntent, "Select Image")
            chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))
            startActivityForResult(chooser, GALLERY_REQUEST_CODE)
        }

        done_btn.setOnClickListener {
            if (imageString != null) {
                val uid = auth.currentUser?.uid
                if (uid != null) {
                    database.reference.child("Users").child(uid).child("image").setValue(imageString)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, Profile::class.java))
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show()
                        }
                }
            } else {
                startActivity(Intent(this, Profile::class.java))
                finish()
            }
        }

        cancel_btn.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))
            finish()
        }
    }

    private fun loadProfileImage() {
        val uid = auth.currentUser?.uid ?: return
        val ref = database.reference.child("Users").child(uid).child("image")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val base64String = snapshot.getValue(String::class.java)
                if (base64String != null) {
                    val imageBytes = Base64.decode(base64String, Base64.DEFAULT)
                    val bitmap = android.graphics.BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                    profileImage.setImageBitmap(bitmap)
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (data?.extras?.get("data") != null) {
                // from camera
                val photo = data.extras?.get("data") as Bitmap
                profileImage.setImageBitmap(photo)
                imageString = bitmapToBase64(photo)
            } else if (data?.data != null) {
                // from gallery
                val uri: Uri? = data.data
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                profileImage.setImageBitmap(bitmap)
                imageString = bitmapToBase64(bitmap)
            }
        }
    }

    private fun bitmapToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}
