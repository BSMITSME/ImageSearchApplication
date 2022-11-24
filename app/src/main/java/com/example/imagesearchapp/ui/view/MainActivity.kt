package com.example.imagesearchapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.setupWithNavController
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.ActivityMainBinding
import com.example.imagesearchapp.repository.ImageSearchRepositoryImpl
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var imageSearchViewModel : ImageSearchViewModel
    lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        navigation()
        val imageSearchRepository = ImageSearchRepositoryImpl()
        val factory = ImageSearchViewModelFactory(imageSearchRepository)
        imageSearchViewModel = ViewModelProvider(this, factory).get(ImageSearchViewModel::class.java)

    }


    fun navigation(){
        val host = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHost
        navController = host.navController
        binding.bottomNav.setupWithNavController(navController)
    }


}