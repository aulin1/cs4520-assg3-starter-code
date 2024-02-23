package com.cs4520.assignment3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.cs4520.assignment3.databinding.HomeFragmentBinding

class HomeFragment : Fragment(R.layout.home_fragment){
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.MVPButton.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_MVP) }
        binding.MVVMButton.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_MVVM) }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}