package com.example.imagesearchapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.imagesearchapp.R
import com.example.imagesearchapp.data.db.ImageSearchDatabase
import com.example.imagesearchapp.databinding.ActivityLoginBinding
import com.example.imagesearchapp.databinding.FragmentLoginBinding
import com.example.imagesearchapp.repository.ImageSearchRepositoryImpl
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModelFactory

class LoginActivity : AppCompatActivity() {
    private val binding : ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity()::class.java)
            startActivity(intent)
        }
        binding.btnNew.setOnClickListener {
            val intent = Intent(this, SignUpActivity()::class.java)
            startActivity(intent)
        }

    }
}