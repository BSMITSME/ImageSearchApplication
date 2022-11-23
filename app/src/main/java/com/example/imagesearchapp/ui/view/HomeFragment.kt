package com.example.imagesearchapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentHomeBinding
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel

class HomeFragment :Fragment(){
    private var _binding : FragmentHomeBinding ?= null
    private val binding get() = _binding!!
    private lateinit var imageSearchViewModel : ImageSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel


    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}

