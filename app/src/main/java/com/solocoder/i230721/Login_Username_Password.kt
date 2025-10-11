package com.solocoder.i230721

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Login_Username_Password : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_username_password)
    var loginButton=findViewById<TextView>(R.id.loginButton)
        loginButton.setOnClickListener {
            val intent = Intent(this@Login_Username_Password, Main_feed::class.java)
            startActivity(intent)
            finish()
        }
        var backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            val intent = Intent(this@Login_Username_Password, Login_Page::class.java)
            startActivity(intent)
            finish()
        }

        var signUp = findViewById<TextView>(R.id.signUp)
        signUp.setOnClickListener {
            val intent = Intent(this@Login_Username_Password, Sign_up::class.java)
            startActivity(intent)
            finish()
        }
    }
}
