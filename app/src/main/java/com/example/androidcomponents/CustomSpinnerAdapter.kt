package com.example.androidcomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton

class CustomSpinnerAdapter(
    context: Context,
    private val resource: Int,
    items: List<String>
) : ArrayAdapter<String>(context, resource, items) {

    // Tracks the selected position within the spinner
    private var selectedPosition = -1

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(resource, parent, false)
        val radioButton = view.findViewById<RadioButton>(R.id.radio_button)
        radioButton.text = getItem(position)
        radioButton.isChecked = position == selectedPosition

        return view
    }

    // Call this method when a dropdown item is selected
    fun onItemSelected(position: Int) {
        if (position != selectedPosition) {
            selectedPosition = position
            notifyDataSetChanged() // Notify that the data has changed to update the UI
        }
    }

    fun getSelectedPosition(): Int {
        return selectedPosition
    }
}

