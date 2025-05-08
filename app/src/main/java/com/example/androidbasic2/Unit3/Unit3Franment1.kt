package com.example.androidbasic2.Unit3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidbasic2.R

class Unit3Franment1 : Fragment () {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?) : View? {
        return inflater.inflate(R.layout.unit3_fragment_1, container, false)
    }
}
