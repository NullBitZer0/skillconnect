package com.example.skillconnect

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ViewDetailsActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details)

        setupViews()
        setupClickListeners()
        loadRequestData()
    }

    private fun setupViews() {
        // Views are already defined in the layout
    }

    private fun setupClickListeners() {
        val btnBack = findViewById<ImageView>(R.id.btn_back)
        val btnMessage = findViewById<Button>(R.id.btn_message)
        val btnOfferHelp = findViewById<Button>(R.id.btn_offer_help)

        // Back button
        btnBack.setOnClickListener {
            finish()
        }

        // Message button
        btnMessage.setOnClickListener {
            Toast.makeText(this, "Message feature coming soon!", Toast.LENGTH_SHORT).show()
        }

        // Offer Help button
        btnOfferHelp.setOnClickListener {
            showOfferHelpDialog()
        }
    }

    private fun loadRequestData() {
        // Get data from intent extras if passed from fragment
        val title = intent.getStringExtra("title") ?: "Need help fixing a leaky sink"
        val description = intent.getStringExtra("description") ?: "My kitchen sink has been leaking for two days. The leak is coming from under the sink near the pipes. It's getting worse and I need someone with basic plumbing skills to help fix it. I have some basic tools but may need additional parts."
        val category = intent.getStringExtra("category") ?: "home"
        val distance = intent.getStringExtra("distance") ?: "0.8 miles away"
        val time = intent.getStringExtra("time") ?: "Posted 2h ago"
        val payment = intent.getStringExtra("payment") ?: "$35"

        // Update UI with data
        findViewById<TextView>(R.id.tv_title).text = title
        findViewById<TextView>(R.id.tv_description).text = description
        findViewById<TextView>(R.id.tv_category).text = category
        findViewById<TextView>(R.id.tv_distance).text = distance
        findViewById<TextView>(R.id.tv_time).text = time
        findViewById<TextView>(R.id.tv_payment).text = payment

        // Set category background color based on category
        val tvCategory = findViewById<TextView>(R.id.tv_category)
        when (category.lowercase()) {
            "home" -> {
                tvCategory.setBackgroundResource(R.drawable.category_badge_bg)
                tvCategory.setTextColor(resources.getColor(R.color.orange_600, null))
            }
            "tech" -> {
                tvCategory.setBackgroundResource(R.drawable.category_badge_bg)
                tvCategory.setTextColor(resources.getColor(R.color.green_600, null))
            }
            "education" -> {
                tvCategory.setBackgroundResource(R.drawable.category_badge_bg) 
                tvCategory.setTextColor(resources.getColor(R.color.blue_600, null))
            }
        }
    }

    private fun showOfferHelpDialog() {
        // Simple toast for now, can be replaced with a proper dialog
        Toast.makeText(this, "Help offer sent successfully!", Toast.LENGTH_SHORT).show()
        
        // You could add actual functionality here like:
        // - Show a dialog to confirm the offer
        // - Send data to backend
        // - Navigate to a chat screen
        // - etc.
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}