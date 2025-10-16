package com.solocoder.i230721

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Startup_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.startup_screen)

        lifecycleScope.launch {
            delay(3000) // wait for 3 seconds
            val intent = Intent(this@Startup_Screen, Login_Username_Password::class.java)
            startActivity(intent)
            finish() // close splash screen so user can’t go back
        }

    }
}