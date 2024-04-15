package com.example.androidcomponents

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.anurag.multiselectionspinner.MultiSelectionSpinnerDialog
import com.anurag.multiselectionspinner.MultiSpinner

class DesignSpinner : AppCompatActivity() , MultiSelectionSpinnerDialog.OnMultiSpinnerSelectionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_spinner)

        val spinnerDrop = findViewById<Spinner>(R.id.spinnerDrop)
        val adapterDrop = CustomSpinnerAdapter(this, R.layout.spinner_radio_item, listOf("Item 1", "Item 2", "Item 3"))
        spinnerDrop.adapter = adapterDrop

        spinnerDrop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                adapterDrop.onItemSelected(position) // Update the adapter with the new selection
              //  parent.dismissDropDown() // Dismiss the dropdown when an item is selected
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Another selection handling here
            }
        }



        //backgronnd
        val spinner: Spinner = findViewById(R.id.spinner)
        val items = arrayOf("Inches", "Feet", "Meters", "Millimeters", "Centimeters")

        val adapter = object : ArrayAdapter<String>(this, R.layout.spinner_selected_item, items) {
            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent)
                if (position == spinner.selectedItemPosition) {
                    view.setBackgroundColor(resources.getColor(R.color.selected_background))
                    (view as TextView).setTextColor(resources.getColor(R.color.selected_text))
                } else {
                    view.setBackgroundColor(resources.getColor(R.color.unselected_background))
                    (view as TextView).setTextColor(resources.getColor(R.color.unselected_text))
                }
                return view
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent)
                view.setBackgroundColor(resources.getColor(R.color.selected_background))
                (view as TextView).setTextColor(resources.getColor(R.color.selected_text))
                return view
            }
        }

        spinner.adapter = adapter
        // Set the dropdown to appear below the Spinner view
        spinner.post {
            spinner.dropDownVerticalOffset = spinner.height
        }


        val multiSpinner: MultiSpinner = findViewById(R.id.spinnerMultiSpinner)

        // List for spinner content
        val contentList = arrayListOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")

        // Initialize the spinner with text content
        multiSpinner.setAdapterWithOutImage(this, contentList, this)

        // Further spinner configuration
        multiSpinner.initMultiSpinner(this, multiSpinner)

    }

    override fun OnMultiSpinnerItemSelected(chosenItems: MutableList<String>?) {
        Log.d("TAG", "OnMultiSpinnerItemSelected: ${chosenItems.toString()}")
    }




}