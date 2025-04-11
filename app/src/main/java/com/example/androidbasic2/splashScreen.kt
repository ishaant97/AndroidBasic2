package com.example.androidbasic2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        android.os.Handler().postDelayed({
            val intent = Intent(this@splashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        },4000)
    }
}