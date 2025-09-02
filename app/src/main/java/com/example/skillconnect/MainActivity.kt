package com.example.skillconnect

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.skillconnect.fragments.ChatFragment
import com.example.skillconnect.fragments.HomeFragment
import com.example.skillconnect.fragments.MapFragment
import com.example.skillconnect.fragments.RequestsFragment
import com.example.skillconnect.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation(savedInstanceState)
        setupFloatingActionButton()
    }

    private fun setupBottomNavigation(savedInstanceState: Bundle?) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set default fragment
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_map -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_requests -> {
                    replaceFragment(RequestsFragment())
                    true
                }
                R.id.nav_chat -> {
                    replaceFragment(ChatFragment())
                    true
                }
                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun setupFloatingActionButton() {
        val fabAddRequest = findViewById<FloatingActionButton>(R.id.fab_add_request)
        
        fabAddRequest.setOnClickListener {
            val dialogFragment = NewSkillRequestDialogFragment()
            dialogFragment.show(supportFragmentManager, "NewSkillRequestDialog")
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_container, fragment)
            .commit()
    }

    fun navigateToMap() {
        replaceFragment(MapFragment())
        // Don't update bottom navigation selection since this is a separate action
    }

    override fun onBackPressed() {
        // Since this is the main activity and we don't want users going back to onboarding,
        // we handle the back press to exit the app instead
        finishAffinity()
    }
}
