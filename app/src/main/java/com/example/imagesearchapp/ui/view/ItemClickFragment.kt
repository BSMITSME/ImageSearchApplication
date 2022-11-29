package com.example.imagesearchapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imagesearchapp.databinding.FragmentItemClickBinding

class ItemClickFragment :Fragment(){
    private var _binding : FragmentItemClickBinding? = null
    private val bidning get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemClickBinding.inflate(inflater, container, false)
        return bidning.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}