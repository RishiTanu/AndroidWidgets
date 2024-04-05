package com.example.androidcomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class CustomSpinnerAdapter(context: Context, resource: Int, objects: List<String>) :
    ArrayAdapter<String>(context, resource, objects) {

    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var items: List<String> = objects
    var selectedPosition: Int? = null // Changed to support single selection

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: inflater.inflate(R.layout.spinner_item_layout, parent, false)

        val textView: TextView = view.findViewById(R.id.textViewSpinnerItem)
        val checkBox: CheckBox = view.findViewById(R.id.checkBoxSpinnerItem)

        textView.text = items[position]
        // Check if the current position is the selected position
        checkBox.isChecked = position == selectedPosition

        checkBox.setOnClickListener {
            // Update the selected position and notify the dataset has changed to refresh the views
            selectedPosition = if (selectedPosition == position) null else position
            notifyDataSetChanged() // Refresh the spinner views
        }

        return view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = inflater.inflate(android.R.layout.simple_spinner_item, parent, false)
        (view as TextView).text = items[selectedPosition ?: position] // Display the selected item
        return view
    }
}

