package com.example.imagesearchapp.ui.view

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import java.lang.Thread.sleep

class SignUpFragment : Fragment() {
    private var _binding : FragmentSignUpBinding ?= null
    private val binding get() = _binding!!
    private lateinit var mainActivity : MainActivity
    lateinit var email : String
    lateinit var password : String
    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainActivity = activity as MainActivity

        mainActivity.hideBottomNavigation(true)
        initSignupButton()

        super.onViewCreated(view, savedInstanceState)
    }
    private fun initSignupButton() {
        binding.btnEnroll.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(context,"회원가입에 성공했습니다!",Toast.LENGTH_SHORT).show()
                        sleep(1000)
                        findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
                    }else{
                        Toast.makeText(context,"이미 존재하는 계정이거나, 회원가입에 실패했습니다.",Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
    override fun onDestroy() {
        _binding = null
        MainActivity().hideBottomNavigation(false)
        super.onDestroy()
    }
}