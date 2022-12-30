package com.example.imagesearchapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imagesearchapp.databinding.FragmentHomeBinding


class Home : Fragment(){
    private var _binding : FragmentHomeBinding?= null
    private val binding get()=_binding!!
    private lateinit var mainActivity : MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val hidebar = activity as MainActivity
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity.hideBottomNavigation(false)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}