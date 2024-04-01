package com.example.androidcomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Spinner

class CustomCheckboxAdapter(
    context: Context,
    private val students: List<String>
) : ArrayAdapter<String>(context, R.layout.spinner_item_checkbox, students) {
    private var selectedPosition = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the custom layout for the main spinner view (closed state).
        // Typically, you might not use a checkbox here, but for simplicity, let's proceed.
        return createItemView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the custom layout for dropdown view items.
        return createItemView(position, convertView, parent)
    }

    private fun createItemView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        // Ensure we're not casting a non-checkbox view
        val view = convertView ?: inflater.inflate(R.layout.spinner_item_checkbox, parent, false)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)

        checkBox.text = getItem(position)
        checkBox.setOnCheckedChangeListener(null) // Clear previous listeners
        checkBox.isChecked = position == selectedPosition // Use selectedPosition to manage selected item
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedPosition = position
                notifyDataSetChanged() // Update for any state change
                // Close the spinner dropdown
                (parent as? Spinner)?.performClick()
            }
        }

        return view
    }
}
