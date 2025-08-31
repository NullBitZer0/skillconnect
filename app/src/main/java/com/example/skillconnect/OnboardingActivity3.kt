package com.example.skillconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_3)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        val btnGetStarted = findViewById<Button>(R.id.btn_get_started)
        val btnSkip = findViewById<TextView>(R.id.btn_skip)

        // Get Started button - navigate to SignUpActivity
        btnGetStarted.setOnClickListener {
            navigateToSignUp()
        }

        // Skip button - navigate directly to MainActivity
        btnSkip.setOnClickListener {
            navigateToMain()
        }
    }

    private fun navigateToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        // Clear the entire onboarding stack so user can't go back to onboarding
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        // Back should go to OnboardingActivity2
        super.onBackPressed()
        finish()
    }
}
