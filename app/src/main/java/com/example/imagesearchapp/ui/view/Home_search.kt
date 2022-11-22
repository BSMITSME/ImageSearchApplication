package com.example.imagesearchapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentHomeSearchBinding
import com.example.imagesearchapp.ui.adapter.ImageSearchAdapter
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel

class Home_search : Fragment(){
    private var _binding : FragmentHomeSearchBinding ?= null
    private val binding get()=_binding!!
    private lateinit var imageSearchViewModel : ImageSearchViewModel
    private lateinit var imageSearchAdapter: ImageSearchAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeSearchBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel

    }



    private fun setupRecycler(){
        imageSearchAdapter = ImageSearchAdapter()
        binding.rvSearchResult.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 3)
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            adapter = imageSearchAdapter
        }
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}
