package com.example.androidbasic2

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ratingBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rating_bar)
        val textView = findViewById<TextView>(R.id.textView)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        ratingBar.setOnRatingBarChangeListener{ _, rating, _ ->
            textView.text = "The rating is ${rating.toString()}"
        }
    }
}