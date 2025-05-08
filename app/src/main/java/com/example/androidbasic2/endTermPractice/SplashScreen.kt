package com.example.androidbasic2.endTermPractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidbasic2.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen2)

        android.os.Handler().postDelayed({
            val intent = Intent(this@SplashScreen, Question2::class.java)
            startActivity(intent)
            finish()
        },5000)
    }
}