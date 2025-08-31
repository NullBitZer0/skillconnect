package com.example.skillconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_1)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        val btnNext = findViewById<Button>(R.id.btn_next)
        val btnSkip = findViewById<TextView>(R.id.btn_skip)

        // Next button - navigate to OnboardingActivity2
        btnNext.setOnClickListener {
            navigateToNext()
        }

        // Skip button - navigate directly to MainActivity
        btnSkip.setOnClickListener {
            skipToMain()
        }
    }

    private fun navigateToNext() {
        val intent = Intent(this, OnboardingActivity2::class.java)
        startActivity(intent)
        // Don't finish this activity so back navigation works
    }

    private fun skipToMain() {
        val intent = Intent(this, MainActivity::class.java)
        // Clear the entire onboarding stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
        // Since this is the first onboarding screen, back should exit the app
        finishAffinity()
    }
}
