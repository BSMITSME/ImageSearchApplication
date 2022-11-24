package com.example.imagesearchapp.ui.view

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentHomeMainBinding
import com.example.imagesearchapp.databinding.FragmentHomeSearchBinding

class HomeMain : Fragment(){
    private var _binding : FragmentHomeMainBinding?= null
    private val binding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}