package com.example.skillconnect.models

data class NearbyRequest(
    val id: Long,
    val title: String,
    val description: String,
    val category: String,
    val distance: String,
    val timeAgo: String
)