package com.example.androidbasic2.Unit6


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.androidbasic2.R
import com.example.unit6.GalleryFragment
import com.example.unit6.HomeFragment
import com.example.unit6.SettingFragment
import com.google.android.material.navigation.NavigationView

class navigatorDemo  : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_navigator_demo)
        // Setup toolbar
        var toolbar = findViewById<Toolbar>(R.id.toolbar2)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerLayout = findViewById(R.id.main)
        val navView: NavigationView = findViewById(R.id.nav)

        // Setup drawer toggle
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // Handle navigation item clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment(), "Home")
                R.id.nav_gallery -> replaceFragment(GalleryFragment(), "Gallery")
                R.id.nav_settings -> replaceFragment(SettingFragment(), "Settings")

            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Set default fragment
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment(), "Gallery")
            navView.setCheckedItem(R.id.nav_gallery)
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.framemenu, fragment)
            .commit()
        supportActionBar?.title = title
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}