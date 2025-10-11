package com.solocoder.i230721

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class Login_Page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }


        var loginButton= findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener(
            {
            val intent: Intent = Intent(this@Login_Page, Main_feed::class.java)
            startActivity(intent)
            finish() // optional → closes LoginActivity
        })
        var signUpLink= findViewById<TextView>(R.id.signUpLink)
        signUpLink.setOnClickListener(
            {
                val intent: Intent = Intent(this@Login_Page, Sign_up::class.java)
                startActivity(intent)
                finish() // optional → closes LoginActivity
            })

        var switchAccount= findViewById<TextView>(R.id.switchAccount)
        switchAccount.setOnClickListener(
            {
                val intent: Intent = Intent(this@Login_Page, Login_Username_Password::class.java)
                startActivity(intent)
                finish() // optional → closes LoginActivity
            })

    }
}