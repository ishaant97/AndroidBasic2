package com.example.androidbasic2.Unit6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Viewgroup(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CameraFragment()
            1 -> ChatFragment()
            2 -> ProfileFragment()
            else -> throw IllegalStateException("Invalid position: $position")
        }
    }

    fun getTabTitle(position : Int): String{
        return when (position) {
            0 -> "Camera"
            1 -> "Chat"
            2 -> "Profile"
            else -> throw IllegalStateException("Invalid position: $position")
        }
    }
}