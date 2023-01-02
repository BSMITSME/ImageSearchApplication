package com.example.imagesearchapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.imagesearchapp.databinding.ActivityLoginWindowBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginWindowActivity : AppCompatActivity() {
    private val binding : ActivityLoginWindowBinding by lazy {
        ActivityLoginWindowBinding.inflate(layoutInflater)
    }
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        binding.btnLogin.setOnClickListener {
            signinEmail()
        }

    }
    fun signinEmail(){
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()
        auth.signInWithEmailAndPassword(email, password).
        addOnCompleteListener { task ->
            if(task.isSuccessful){
                movePage(task.result.user)
            }
            else{
                Toast.makeText(this, "로그인에 실패했습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun movePage(user:FirebaseUser?){
        if(user != null){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}