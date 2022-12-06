package com.example.imagesearchapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentHomeMainBinding
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class HomeMain : Fragment(){
    private var _binding : FragmentHomeMainBinding?= null
    private val binding get()=_binding!!
    private lateinit var imageSearchViewModel: ImageSearchViewModel
    private val args by navArgs<ItemClickFragmentArgs>()

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
        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel
        binding.imgSearch.setOnClickListener {
            findNavController().navigate(R.id.main_to_search)
        }
        binding.mainImag.load(R.drawable.pasted_graphic)


    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}