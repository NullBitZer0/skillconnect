package com.example.skillconnect

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 3 seconds delay before navigating to onboarding
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToOnboarding()
        }, 3000) // 3 seconds delay
    }

    private fun navigateToOnboarding() {
        val intent = Intent(this, OnboardingActivity1::class.java)
        startActivity(intent)
        finish() // Close splash activity
    }

    override fun onBackPressed() {
        // Disable back button on splash screen
        // Do nothing to prevent going back
    }
}
