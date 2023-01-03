package com.example.imagesearchapp.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.animation.slideIn
import androidx.navigation.fragment.findNavController
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentSettingBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import java.lang.Thread.sleep

class SettingFragment :Fragment(){
    private var _binding : FragmentSettingBinding ?= null
    private val binding get()= _binding!!
    private lateinit var auth : FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding.btnLogout.setOnClickListener {
            auth.signOut()
            sleep(1000)
            Toast.makeText(this.context, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}