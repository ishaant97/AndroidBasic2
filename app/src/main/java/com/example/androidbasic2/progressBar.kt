package com.example.androidbasic2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class progressBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_progress_bar)
        val progressBar = findViewById<View>(R.id.progressBar)
        val btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener{
            progressBar.visibility = View.VISIBLE

            btn.isEnabled = false
        }

    }
}