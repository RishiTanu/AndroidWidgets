package com.example.androidcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class MultiSpinnerActivity : AppCompatActivity() {
    private lateinit var autoCompleteTextView: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_spinner)

        autoCompleteTextView = findViewById(R.id.autocompleteAirport)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line)
        autoCompleteTextView.setAdapter(adapter)

        autoCompleteTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called to notify you that, within s, the count characters beginning at start are about to be replaced by new text with length after.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // This method is called to notify you that, within s, the count characters beginning at start have just replaced old text that had length before.
            }

            override fun afterTextChanged(s: Editable?) {
                // This method is called to notify you that, somewhere within s, the text has been changed.
                if (s != null && s.isNotEmpty()) {
                    // API call or data filtering logic goes here
                   // loadDataFromAPI(s.toString())  // Call your own method to load data
                }
            }
        })

        // Assume loadDataFromAPI is a method you'll define to perform the API request and process the response:
        //private fun loadDataFromAPI(query: String) {
            // Your API call logic to load

            //autoCompleteTextView.addTextChangedListener { text ->
           // if (!text.isNullOrEmpty()) {
                /*RetrofitClient.service.getAirports(text.toString()).enqueue(object : Callback<List<String>> {
                    override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                        if (response.isSuccessful) {
                            adapter.clear()
                            adapter.addAll(response.body() ?: emptyList())
                            adapter.notifyDataSetChanged()
                        }
                    }

                    override fun onFailure(call: Call<List<String>>, t: Throwable) {
                        // Handle failure
                    }
                })*/
           // }
       // }
    }
}

/*
interface AirportService {
    @GET("getAirports")
    fun getAirports(@Query("query") query: String): Call<List<String>>  // Assume API returns a list of airport names
}*/

/*
val navController = findNavController(R.id.nav_host_fragment)
val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
bottomNav.setupWithNavController(navController)*/
