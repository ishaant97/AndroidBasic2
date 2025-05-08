package com.example.androidbasic2.Unit6

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.androidbasic2.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SwipeView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_swipe_view)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout) // Corrected variable name

        val adapter = Viewgroup(this)
        viewPager.adapter = adapter // Use the adapter instance

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getTabTitle(position)
        }.attach() // Attach the mediator

    }
}