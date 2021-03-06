package com.example.blogapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.blogapp.R
import com.example.blogapp.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        isUserAuthenticated()
        isUserUnauthenticated()
    }

    private fun isUserAuthenticated() {
        //currentUser is null by default
        firebaseAuth.currentUser?.let {//If currentUser is NOT null redirect them to home
            findNavController().navigate(R.id.action_loginFragment_to_homeScreenFragment)
        }
    }

    private fun isUserUnauthenticated() {
        binding.btnSignIn.setOnClickListener{
            val userEmail = binding.etEmail.text.toString().trim()
            val userPassword = binding.etPassword.text.toString().trim()

            validateCredentials(userEmail, userPassword)
        }
    }

    private fun validateCredentials(email: String, password: String) {
        if (email.isEmpty()) {
            binding.etEmail.error = "Email is empty"
            return
        }

        if (password.isEmpty()) {
            binding.etPassword.error = "Password is empty"
            return
        }
    }
}