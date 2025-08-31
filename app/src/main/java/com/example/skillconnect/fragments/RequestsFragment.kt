package com.example.skillconnect.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.skillconnect.R
import com.example.skillconnect.ViewDetailsActivity

class RequestsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_requests, container, false)
        setupClickListeners(view)
        return view
    }

    private fun setupClickListeners(view: View) {
        // Find all "View Details" buttons and set click listeners
        findViewDetailsButtons(view)
    }

    private fun findViewDetailsButtons(view: View) {
        // Find all buttons with "View Details" text
        val buttons = mutableListOf<Button>()
        findButtonsRecursively(view as ViewGroup, buttons)
        
        buttons.filter { it.text.toString().contains("View Details") }.forEachIndexed { index, button ->
            button.setOnClickListener {
                when (index) {
                    0 -> navigateToViewDetails("Need help fixing a leaky sink", 
                        "My kitchen sink has been leaking for two days. Need someone with basic plumbing skills.", 
                        "home", "0.8 miles", "2h ago", "$35")
                    1 -> navigateToViewDetails("Guitar lesson for beginner", 
                        "I just got my first acoustic guitar and would love a 1-hour lesson to learn the basics.", 
                        "education", "1.2 miles", "4h ago", "$25")
                    2 -> navigateToViewDetails("Help setting up home wifi network", 
                        "Just moved to a new apartment and need help setting up my wifi router.", 
                        "tech", "1.5 miles", "1d ago", "$30")
                }
            }
        }
    }

    private fun findButtonsRecursively(viewGroup: ViewGroup, buttons: MutableList<Button>) {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            when (child) {
                is Button -> buttons.add(child)
                is ViewGroup -> findButtonsRecursively(child, buttons)
            }
        }
    }

    private fun navigateToViewDetails(title: String, description: String, category: String, 
                                    distance: String, time: String, payment: String) {
        val intent = Intent(requireContext(), ViewDetailsActivity::class.java).apply {
            putExtra("title", title)
            putExtra("description", description)
            putExtra("category", category)
            putExtra("distance", distance)
            putExtra("time", time)
            putExtra("payment", payment)
        }
        startActivity(intent)
    }
}