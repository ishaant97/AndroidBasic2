package com.example.androidbasic2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class static_fragment extends Fragment {
    public view onCreateView(LayoutInflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.static_fragment, container, false);
    }
}
