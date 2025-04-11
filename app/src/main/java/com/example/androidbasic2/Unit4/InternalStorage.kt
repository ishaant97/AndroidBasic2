package com.example.androidbasic2.Unit4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidbasic2.R

class InternalStorage : AppCompatActivity() {
    private lateinit var etStudentName: EditText
    private lateinit var etGrade: EditText
    private val fileName = "student_grade.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_internal_storage)
        etStudentName = findViewById(R.id.etName)
        etGrade = findViewById(R.id.etGrade)

        val btnSave = findViewById<Button>(R.id.save_password)
        val btnClear = findViewById<Button>(R.id.clear_details)
        val btnView = findViewById<Button>(R.id.get_details)
        btnSave.setOnClickListener{ saveGrade() }
        btnClear.setOnClickListener{ clearGrade() }
        btnView.setOnClickListener{ loadGrage() }
    }
    private fun saveGrade() {
        val studentName = etStudentName.text.toString()
        val grade = etGrade.text.toString()
        if(studentName.isEmpty() || grade.isEmpty()) {
            Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
            return
        }
        val data = "$studentName\n$grade"
        try {
            openFileOutput(fileName,MODE_PRIVATE).use {
                it.write(data.toByteArray())
            }
            Toast.makeText(this, "Grade saved to internal storage", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show()
        }
    }
    private fun loadGrage() {
        openFileInput(fileName).use { stream ->
            val lines = stream.bufferedReader().readLines()
            if(lines.size >= 2){
                etStudentName.setText(lines[0])
                etGrade.setText(lines[1])
            } else {
                Toast.makeText(this, "No data to load", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun clearGrade() {
        etStudentName.setText("")
        etGrade.setText("")
    }
}