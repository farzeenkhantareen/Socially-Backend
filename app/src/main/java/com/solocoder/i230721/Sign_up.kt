package com.solocoder.i230721

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.io.ByteArrayOutputStream

class Sign_up : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private var imageString: String? = null
    private val IMAGE_PICK_CODE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.sign_up)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val backArrow = findViewById<ImageView>(R.id.backArrow)
        val uploadImage = findViewById<ImageView>(R.id.profileImage)
        val usernameField = findViewById<EditText>(R.id.username)
        val firstNameField = findViewById<EditText>(R.id.firstName)
        val lastNameField = findViewById<EditText>(R.id.lastName)
        val dobField = findViewById<EditText>(R.id.dateOfBirth)
        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)
        val createAccountBtn = findViewById<Button>(R.id.createAccountBtn)

        backArrow.setOnClickListener {
            startActivity(Intent(this@Sign_up, Login_Page::class.java))
            finish()
        }

        uploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, IMAGE_PICK_CODE)
        }

        createAccountBtn.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val firstName = firstNameField.text.toString().trim()
            val lastName = lastNameField.text.toString().trim()
            val dob = dobField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (username.isEmpty() || firstName.isEmpty() || lastName.isEmpty() ||
                dob.isEmpty() || email.isEmpty() || password.isEmpty() || imageString == null
            ) {
                Toast.makeText(this, "Fill all fields and upload image", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val uid = auth.currentUser?.uid ?: return@addOnCompleteListener
                    val userMap = HashMap<String, Any>()
                    userMap["username"] = username
                    userMap["firstName"] = firstName
                    userMap["lastName"] = lastName
                    userMap["dob"] = dob
                    userMap["email"] = email
                    userMap["image"] = imageString!!

                    database.reference.child("Users").child(uid).setValue(userMap)
                        .addOnSuccessListener {
                            startActivity(Intent(this@Sign_up, Login_Username_Password::class.java))
                            finish()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this, "Database error: ${it.message}", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    Toast.makeText(this, "Auth error: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK) {
            val uri: Uri? = data?.data
            val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
            val uploadImage = findViewById<ImageView>(R.id.profileImage)
            uploadImage.setImageBitmap(bitmap)
            imageString = bitmapToBase64(bitmap)
        }
    }

    private fun bitmapToBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream)
        val byteArray = byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}
