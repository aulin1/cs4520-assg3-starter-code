package com.cs4520.assignment3

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment(R.layout.home_fragment){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mvpbutton : Button = view.findViewById(R.id.MVPButton)
        val mvvmbutton : Button = view.findViewById(R.id.MVVMButton)
        mvpbutton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_MVP)
        }
        mvvmbutton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_MVVM)
        }
    }
}