package com.example.androidbasic2

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class customToast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_toast)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener{
            val layout1 = layoutInflater.inflate(R.layout.support_custom_toast, null)
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout1
            toast.show()
        }
    }
}