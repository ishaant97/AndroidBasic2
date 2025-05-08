package com.example.androidbasic2.endTermPractice

import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidbasic2.R

class Question2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question2)
//        val radioGrp = findViewById<RadioGroup>(R.id.radioGrp)
//        val checkedRadioButtonId = radioGrp.checkedRadioButtonId
        val layout = layoutInflater.inflate(R.layout.custom_toast,null)

        val btn = findViewById<Button>(R.id.submitBtn)
        btn.setOnClickListener {
            val toast = Toast(this)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = layout
            toast.show()
        }
    }
}