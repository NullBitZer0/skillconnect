package com.example.skillconnect.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.skillconnect.R
import com.example.skillconnect.models.NearbyRequest

class NearbyRequestsAdapter(
    private val onRequestClick: (NearbyRequest) -> Unit
) : ListAdapter<NearbyRequest, NearbyRequestsAdapter.RequestViewHolder>(RequestDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nearby_request, parent, false)
        return RequestViewHolder(view, onRequestClick)
    }

    override fun onBindViewHolder(holder: RequestViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RequestViewHolder(
        itemView: View,
        private val onRequestClick: (NearbyRequest) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val tvTitle: TextView = itemView.findViewById(R.id.tv_request_title)
        private val tvDescription: TextView = itemView.findViewById(R.id.tv_request_description)
        private val tvCategory: TextView = itemView.findViewById(R.id.tv_category_badge)
        private val tvDistance: TextView = itemView.findViewById(R.id.tv_distance)
        private val tvTimeAgo: TextView = itemView.findViewById(R.id.tv_time_ago)

        fun bind(request: NearbyRequest) {
            tvTitle.text = request.title
            tvDescription.text = request.description
            tvCategory.text = request.category
            tvDistance.text = request.distance
            tvTimeAgo.text = request.timeAgo

            itemView.setOnClickListener {
                onRequestClick(request)
            }
        }
    }

    private class RequestDiffCallback : DiffUtil.ItemCallback<NearbyRequest>() {
        override fun areItemsTheSame(oldItem: NearbyRequest, newItem: NearbyRequest): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NearbyRequest, newItem: NearbyRequest): Boolean {
            return oldItem == newItem
        }
    }
}