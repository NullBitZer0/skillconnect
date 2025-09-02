package com.example.skillconnect

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment

class NewSkillRequestDialogFragment : DialogFragment() {

    private lateinit var etTitle: EditText
    private lateinit var etDescription: EditText
    private lateinit var spinnerCategory: Spinner
    private lateinit var etBudget: EditText
    private lateinit var tvLocation: TextView
    private lateinit var layoutAddPhoto: LinearLayout
    private lateinit var btnCancel: Button
    private lateinit var btnPostRequest: Button
    private lateinit var btnClose: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Light_Dialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_new_skill_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        initViews(view)
        setupCategorySpinner()
        setupClickListeners()
    }

    private fun initViews(view: View) {
        etTitle = view.findViewById(R.id.et_title)
        etDescription = view.findViewById(R.id.et_description)
        spinnerCategory = view.findViewById(R.id.spinner_category)
        etBudget = view.findViewById(R.id.et_budget)
        tvLocation = view.findViewById(R.id.tv_location)
        layoutAddPhoto = view.findViewById(R.id.layout_add_photo)
        btnCancel = view.findViewById(R.id.btn_cancel)
        btnPostRequest = view.findViewById(R.id.btn_post_request)
        btnClose = view.findViewById(R.id.btn_close)
    }

    private fun setupCategorySpinner() {
        val categories = arrayOf(
            "Select a category",
            "Home Repair",
            "Technology",
            "Tutoring",
            "Moving",
            "Cleaning",
            "Gardening",
            "Automotive",
            "Beauty & Wellness",
            "Pet Care",
            "Other"
        )
        
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            categories
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategory.adapter = adapter
    }

    private fun setupClickListeners() {
        btnClose.setOnClickListener {
            dismiss()
        }

        btnCancel.setOnClickListener {
            dismiss()
        }

        btnPostRequest.setOnClickListener {
            if (validateForm()) {
                postRequest()
            }
        }

        tvLocation.setOnClickListener {
            // Handle location selection
            Toast.makeText(context, "Location selection not implemented yet", Toast.LENGTH_SHORT).show()
        }

        layoutAddPhoto.setOnClickListener {
            // Handle photo upload
            Toast.makeText(context, "Photo upload not implemented yet", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validateForm(): Boolean {
        val title = etTitle.text.toString().trim()
        val description = etDescription.text.toString().trim()
        val budget = etBudget.text.toString().trim()
        
        when {
            title.isEmpty() -> {
                etTitle.error = "Title is required"
                etTitle.requestFocus()
                return false
            }
            description.isEmpty() -> {
                etDescription.error = "Description is required"
                etDescription.requestFocus()
                return false
            }
            spinnerCategory.selectedItemPosition == 0 -> {
                Toast.makeText(context, "Please select a category", Toast.LENGTH_SHORT).show()
                return false
            }
            budget.isEmpty() -> {
                etBudget.error = "Budget is required"
                etBudget.requestFocus()
                return false
            }
            else -> return true
        }
    }

    private fun postRequest() {
        val title = etTitle.text.toString().trim()
        val description = etDescription.text.toString().trim()
        val category = spinnerCategory.selectedItem.toString()
        val budget = etBudget.text.toString().trim()
        
        // Here you would typically save the request to a database or send to a server
        Toast.makeText(context, "Request posted successfully!", Toast.LENGTH_LONG).show()
        dismiss()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
}