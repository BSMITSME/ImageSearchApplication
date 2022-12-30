package com.example.imagesearchapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding?= null
    private val binding get() = _binding!!

    private lateinit var mainActivity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainActivity = activity as MainActivity
        mainActivity.hideBottomNavigation(true)
        binding.btnNew.setOnClickListener {
            //findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
       mainActivity.hideBottomNavigation(false)
        _binding = null
        super.onDestroy()
    }
}