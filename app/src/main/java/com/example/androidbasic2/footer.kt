package com.example.androidbasic2

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class footer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_footer)

        val listView = findViewById<ListView>(R.id.listView)
        val arr = arrayOf("Ishaant", "Shruti", "Abhishek", "Shashwat", "Priya", "Yousuf", "Aryan", "Archit")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)

        val listFooter = layoutInflater.inflate(R.layout.footer_list, listView, false) as ViewGroup
        listView.addFooterView(listFooter)
        listView.adapter  = arrayAdapter
    }
}