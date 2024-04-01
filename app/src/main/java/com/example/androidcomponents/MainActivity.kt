package com.example.androidcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switchCompat: SwitchCompat = findViewById(R.id.switchCompat)
        switchCompat.thumbDrawable = ContextCompat.getDrawable(this, R.drawable.switch_thumb)
        switchCompat.trackDrawable = ContextCompat.getDrawable(this, R.drawable.switch_track)

        /*val spinner: Spinner = findViewById(R.id.mySpinner)
        spinner.background = getDrawable(R.drawable.spinner_background)

        // Initialize a list of options for the spinner
        val options = arrayOf("Select Gender","Option 1", "Option 2", "Option 3")

        // Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        spinner.adapter = adapter*/

        /*val searchView = findViewById<SearchView>(R.id.searchView)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // User pressed the search button
                Toast.makeText(applicationContext, "Search query: $query", Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // User changed the text
                return true
            }
        })*/

        val students = listOf("Student 1", "Student 2", "Student 3", "Student 4")
        val adapter11 = CustomCheckboxAdapter(this,students)

        val spinner11: Spinner = findViewById(R.id.spinnerItem)
        spinner11.adapter = adapter11

        spinner11.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
               // adapter11.selectItem(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No operation needed here for this scenario.
            }
        }
    }


}