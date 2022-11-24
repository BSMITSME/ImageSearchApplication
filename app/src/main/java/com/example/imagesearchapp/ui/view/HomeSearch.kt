package com.example.imagesearchapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.example.imagesearchapp.databinding.FragmentHomeSearchBinding


class HomeSearch : Fragment(){
    private var _binding : FragmentHomeSearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        _binding =null
        super.onDestroy()
    }
}