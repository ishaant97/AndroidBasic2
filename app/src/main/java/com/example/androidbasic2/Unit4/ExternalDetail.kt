package com.example.androidbasic2.Unit4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidbasic2.R
import java.io.File
import java.io.FileInputStream

class ExternalDetail : AppCompatActivity() {

    lateinit var fstream : FileInputStream
//    private val filename : "SampleFile.txt"
    private val filePath = "MyFileStorage"
    lateinit var myExternalFile : File


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_external_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = findViewById<TextView>(R.id.resultView)
//        val backBtn = findViewById<Button>(R.id.backBtn)

//        try {
//            myExternalFile = File(getExternalFilesDir(filePath),filename)
//            fstream = FileInputStream(myExternalFile)
//            val sbuffer = StringBuilder()
//            val char = fstream.read()
//            while (char != -1){
//                sbuffer.append(char.toChar())
//                char = fStream.read()
//            }
//            fstream.close()
//            val detail = sbuffer.toString().split("\n").toTypedArray()
//            var n = detail.size
//            val text = " "
//            for (i in 0 <= until < n-1){
//
//            }
//        }


    }
}