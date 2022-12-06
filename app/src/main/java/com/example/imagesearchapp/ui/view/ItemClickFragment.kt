package com.example.imagesearchapp.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.imagesearchapp.databinding.FragmentItemClickBinding
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.google.android.material.snackbar.Snackbar

class ItemClickFragment :Fragment(){
    private var _binding : FragmentItemClickBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ItemClickFragmentArgs>()
    private lateinit var imageSearchViewModel: ImageSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemClickBinding.inflate(inflater, container, false)
        return binding.root
    }

//    @SuppressLint("SetJAvaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel
        val image = args.image
        binding.imageView.load(image.imageUrl)

        binding.fabFavorite.setOnClickListener {
            imageSearchViewModel.saveImage(image)
            Snackbar.make(view, "Image has saved", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        _binding = null

        super.onDestroy()
    }

}

