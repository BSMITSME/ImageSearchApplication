package com.example.imagesearchapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.ActivityLoginBinding
import com.example.imagesearchapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private val binding : ActivitySignUpBinding by lazy {
        ActivitySignUpBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        initSignupButton()

    }
    private fun initSignupButton() {
        binding.btnEnroll.setOnClickListener {
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.text.toString()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "회원가입에 성공했습니다!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "이미 존재하는 계정이거나, 회원가입에 실패했습니다.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

        }
    }
    }