package com.example.skillconnect.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.skillconnect.MainActivity
import com.example.skillconnect.R
import com.example.skillconnect.adapters.NearbyRequestsAdapter
import com.example.skillconnect.models.NearbyRequest

class HomeFragment : Fragment() {

    private lateinit var btnStartExploring: Button
    private lateinit var etSearch: EditText
    private lateinit var tvSeeAllRequests: TextView
    private lateinit var rvNearbyRequests: RecyclerView
    private lateinit var nearbyRequestsAdapter: NearbyRequestsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        initViews(view)
        setupRecyclerView()
        setupClickListeners()
        loadNearbyRequests()
    }

    private fun initViews(view: View) {
        btnStartExploring = view.findViewById(R.id.btn_start_exploring)
        etSearch = view.findViewById(R.id.et_search)
        tvSeeAllRequests = view.findViewById(R.id.tv_see_all_requests)
        rvNearbyRequests = view.findViewById(R.id.rv_nearby_requests)
    }

    private fun setupRecyclerView() {
        nearbyRequestsAdapter = NearbyRequestsAdapter { request ->
            onRequestClicked(request)
        }
        rvNearbyRequests.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = nearbyRequestsAdapter
            isNestedScrollingEnabled = false
        }
    }

    private fun setupClickListeners() {
        btnStartExploring.setOnClickListener {
            // Navigate to map fragment
            val activity = requireActivity() as MainActivity
            activity.navigateToMap()
        }

        tvSeeAllRequests.setOnClickListener {
            // Navigate to requests tab
            Toast.makeText(context, "See All clicked", Toast.LENGTH_SHORT).show()
        }

        etSearch.setOnEditorActionListener { _, _, _ ->
            performSearch(etSearch.text.toString())
            true
        }
    }

    private fun loadNearbyRequests() {
        // Sample data - in a real app, this would come from an API or database
        val sampleRequests = listOf(
            NearbyRequest(
                id = 1,
                title = "Need help fixing a leaky sink",
                description = "My kitchen sink has been leaking for two days. I've tried tightening the pipes but it's still dripping.",
                category = "home",
                distance = "0.8 miles",
                timeAgo = "2h ago"
            ),
            NearbyRequest(
                id = 2,
                title = "Guitar lesson for beginner",
                description = "I just got my first acoustic guitar and would love a 1-hour lesson to learn the basics. I know nothing",
                category = "education",
                distance = "1.2 miles",
                timeAgo = "4h ago"
            ),
            NearbyRequest(
                id = 3,
                title = "Help setting up home wifi network",
                description = "Just moved to a new apartment and need help setting up my wifi router and connecting all my",
                category = "tech",
                distance = "1.5 miles",
                timeAgo = "1d ago"
            )
        )
        
        nearbyRequestsAdapter.submitList(sampleRequests)
    }

    private fun onRequestClicked(request: NearbyRequest) {
        Toast.makeText(context, "Clicked on: ${request.title}", Toast.LENGTH_SHORT).show()
        // Navigate to request details
    }

    private fun performSearch(query: String) {
        if (query.isNotEmpty()) {
            Toast.makeText(context, "Searching for: $query", Toast.LENGTH_SHORT).show()
            // Implement search functionality
        }
    }
}