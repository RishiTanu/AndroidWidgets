package com.example.androidcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.hbb20.CountryCodePicker

class TabActivity : AppCompatActivity() {

    private lateinit var phoneNumberEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        // Adding Tabs and setting their titles
        tabLayout.addTab(tabLayout.newTab().setText("Drone"))
        tabLayout.addTab(tabLayout.newTab().setText("Helicopter"))
        tabLayout.addTab(tabLayout.newTab().setText("Airplane"))

        val ccp: CountryCodePicker = findViewById(R.id.ccp)
        phoneNumberEditText = findViewById<EditText>(R.id.phoneNumbersss)

        phoneNumberEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                validatePhoneNumber(phoneNumberEditText.text.toString(), ccp.selectedCountryNameCode)
            }
        }


        // Listen for country selection
        ccp.setOnCountryChangeListener {
            // Country selected
            val countryCode = ccp.selectedCountryCode
            val countryName = ccp.selectedCountryName
            Toast.makeText(this, "Selected: $countryName, Code: +$countryCode", Toast.LENGTH_LONG).show()
        }


        val spinners: Spinner = findViewById(R.id.spinner)
        val items = listOf("Item 1", "Item 2", "Item 3")
        val adapter = CustomSpinnerAdapter(this, R.layout.spinner_item_layout, items)

        spinners.adapter = adapter
        spinners.setPopupBackgroundResource(R.drawable.bg_spinner_bevel)
    }

    private fun validatePhoneNumber(phoneNumber: String, countryIsoCode: String) {
        val phoneUtil = PhoneNumberUtil.getInstance()
        try {
            val numberProto: Phonenumber.PhoneNumber = phoneUtil.parse(phoneNumber, countryIsoCode)
            val isValid = phoneUtil.isValidNumber(numberProto)

            if (isValid) {
                // The number is valid for the given country ISO code
                phoneNumberEditText.error = null
            } else {
                // The number is not valid
                phoneNumberEditText.error = "Invalid phone number for country"
            }
        } catch (e: Exception) {
            phoneNumberEditText.error = "Invalid phone number"
        }
    }



    //Find the Position of the Item to be Selected
    // Example data from API
/*    val itemsFromApi = listOf("Item 1", "Item 2", "Item 3") // Your API call will provide this list
    val selectedItemFromApi = "Item 2" // And this selected item

    // Populate the spinner with the data
    val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, itemsFromApi)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = adapter

    // Find the position of the selected item
    val position = itemsFromApi.indexOf(selectedItemFromApi)

    // Set the spinner to the selected item
    if (position >= 0) {
        spinner.setSelection(position)
    }*/

}