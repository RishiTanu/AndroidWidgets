package com.example.androidcomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView


class CustomSpinnerAdapter(
    context: Context,
    items: List<String>
) : ArrayAdapter<String>(context, 0, items) {

    private var selectedPosition = -1

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_radio_item, parent, false)
        val radioButton = view.findViewById<RadioButton>(R.id.radio_button)
        val textView = view.findViewById<TextView>(R.id.text_view_spinner_item)

        textView.text = getItem(position)
        radioButton.isChecked = position == selectedPosition

        view.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
            (parent as Spinner).setSelection(position)
            // Optionally close the dropdown if you want to
            // parent.performClick()
        }

        return view
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Here, provide the layout for the selected item which is displayed by the spinner
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_radio_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.text_view_spinner_item)

        // Set the text for the TextView when the Spinner is not expanded
        textView.text = getItem(position)
        return view
    }

    fun onItemSelected(position: Int) {
        selectedPosition = position
        notifyDataSetChanged()
    }

    override fun isEnabled(position: Int): Boolean {
        return true
    }

    fun getSelectedPosition(): Int {
        return selectedPosition
    }
}

