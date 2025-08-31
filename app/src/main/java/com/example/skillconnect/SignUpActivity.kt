package com.example.skillconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        val btnSignUp = findViewById<Button>(R.id.btn_sign_up)
        val tvAlreadyHaveAccount = findViewById<TextView>(R.id.tv_already_have_account)
        val etFullName = findViewById<TextInputEditText>(R.id.et_full_name)
        val etEmail = findViewById<TextInputEditText>(R.id.et_email)
        val etPhone = findViewById<TextInputEditText>(R.id.et_phone)
        val etPassword = findViewById<TextInputEditText>(R.id.et_password)

        // Sign Up button - validate and navigate to SignInActivity
        btnSignUp.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateInput(fullName, email, phone, password)) {
                // Here you would typically save user data or make API call
                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                navigateToSignIn()
            }
        }

        // Already have account - navigate to SignInActivity
        tvAlreadyHaveAccount.setOnClickListener {
            navigateToSignIn()
        }
    }

    private fun validateInput(fullName: String, email: String, phone: String, password: String): Boolean {
        when {
            fullName.isEmpty() -> {
                Toast.makeText(this, "Please enter your full name", Toast.LENGTH_SHORT).show()
                return false
            }
            email.isEmpty() -> {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
                return false
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                return false
            }
            phone.isEmpty() -> {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
                return false
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show()
                return false
            }
            password.length < 6 -> {
                Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        return true
    }

    private fun navigateToSignIn() {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}