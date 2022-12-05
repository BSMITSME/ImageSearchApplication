package com.example.imagesearchapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imagesearchapp.repository.ImageSearchRepository

class ImageSearchViewModelFactory(private val imageSearchRepository : ImageSearchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ImageSearchViewModel::class.java)){
            return ImageSearchViewModel(imageSearchRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }

}
