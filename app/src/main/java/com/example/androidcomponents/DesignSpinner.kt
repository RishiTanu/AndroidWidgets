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


class DesignSpinner : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design_spinner)
        spinnerItem()
        radioSpinner()



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


        /*val multiSpinner: MultiSpinner = findViewById(R.id.spinnerMultiSpinner)

        // List for spinner content
        val contentList = arrayListOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")

        // Initialize the spinner with text content
        multiSpinner.setAdapterWithOutImage(this, contentList, this)

        // Further spinner configuration
        multiSpinner.initMultiSpinner(this, multiSpinner)*/

    }

   /* override fun OnMultiSpinnerItemSelected(chosenItems: MutableList<String>?) {
        Log.d("TAG", "OnMultiSpinnerItemSelected: ${chosenItems.toString()}")
    }*/


    private fun spinnerItem(){

        val spinner: Spinner = findViewById(R.id.spinnerAirspeedUnits)
        spinner.background = ContextCompat.getDrawable(this, R.drawable.spinner_bg) // Set custom background

// Initialize an ArrayAdapter with the custom spinner item layout
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.airspeed_units,
            R.layout.spinner_item
        )
// Specify the custom dropdown layout
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item2)

// Apply the adapter to the spinner
        spinner.adapter = adapter
    }

    private fun radioSpinner() {
        val spinnerDrop: Spinner = findViewById(R.id.spinnerDrop)
        val items = listOf("Item 1", "Item 2", "Item 3")
        val adapterDrop = CustomSpinnerAdapter(this, items)
        spinnerDrop.adapter = adapterDrop

        // Set the initial selection and the dropdown item click behavior
        spinnerDrop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Set the spinner selection to the chosen item
                spinnerDrop.setSelection(position)
                // Notify the adapter about the new selection
                adapterDrop.onItemSelected(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // If required, handle the case where no dropdown item is selected
            }
        }
    }
}