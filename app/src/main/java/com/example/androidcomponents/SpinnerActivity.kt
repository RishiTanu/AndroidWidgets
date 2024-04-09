package com.example.androidcomponents

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.SearchView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import com.example.androidcomponents.databinding.ActivitySpinnerBinding
import com.skydoves.powerspinner.PowerSpinnerView

class SpinnerActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpinnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //spinnerItem()

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            //TopSheetDialogFragment().show(supportFragmentManager, "TopSheetDialog")
            showTopSheet()
        }

        val signUpText = findViewById<TextView>(R.id.tvSignUp)
        val spannableString = SpannableString("Don't have an account? Sign up.")

        spannableString.setSpan(UnderlineSpan(), 23, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // underline "Sign up"
        spannableString.setSpan(ForegroundColorSpan(Color.YELLOW), 23, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // change color of "Sign up"

        signUpText.text = spannableString
        signUpText.movementMethod = LinkMovementMethod.getInstance() // if you want the text to be clickable

        spannableString.setSpan(object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Handle "Sign up" click
            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
                ds.color = Color.RED // Set the link color
            }
        }, 23, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    }

    fun showTopSheet() {
        // Inflate the top sheet layout
        val inflater = LayoutInflater.from(this)
        val topSheetView = inflater.inflate(R.layout.top_sheet_layout, null)

        // Create the PopupWindow
        val topSheetPopup = PopupWindow(this).apply {
            contentView = topSheetView
            width = LinearLayout.LayoutParams.MATCH_PARENT
            height = WRAP_CONTENT
            isFocusable = true // Lets taps outside the popup also dismiss it
            elevation = 10.0f
        }

        // Show the top sheet at the top of the window
        topSheetPopup.showAtLocation(findViewById(android.R.id.content), Gravity.TOP, 0, 0)


        val spinner: Spinner = findViewById(R.id.customSpinner)
        val items = arrayOf("Never show", "Show to all users", "Only show when there is conflict")

        // Create an ArrayAdapter using the custom layout
        val adapter = ArrayAdapter(this, R.layout.custom_spinner_item, items)

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.custom_spinner_item)

// Apply the adapter to the spinner
        spinner.adapter = adapter

// Set the click listener for the spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Handle spinner item selection
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case where no selection is made
            }
        }
    }

    /*private fun spinnerItem(){
        val mySpinner: PowerSpinnerView = findViewById(R.id.mySpinner)

        // List of items for the spinner.
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4")

        // Set the items to the spinner.
        mySpinner.setItems(items)

        // Set item selection listener.
        mySpinner.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            // Handle the selected item.
            Toast.makeText(this@SpinnerActivity, "Selected: $newItem", Toast.LENGTH_SHORT).show()
        }
    }*/

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        customizeSearchView(searchView)

        // Implement search logic here
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Perform the final search
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Text has changed, apply filtering?
                return false
            }
        })

        return true
    }

/*    fun customizeSearchView(searchView: SearchView) {
        val txtSearch = searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        txtSearch.setTextColor(Color.WHITE)
        txtSearch.setHintTextColor(Color.WHITE)

        // Set the query hint if needed
        searchView.queryHint = "Search here..."

        // Changing the search icon
        val searchIcon = searchView.findViewById(androidx.appcompat.R.id.search_mag_icon) as ImageView
        searchIcon.setImageResource(R.drawable.ic_search_white)

        // Changing the clear text button icon
        val clearButton = searchView.findViewById(androidx.appcompat.R.id.search_close_btn) as ImageView
        clearButton.setImageResource(R.drawable.ic_clear_white)
    }*/

    private fun customizeSearchView(searchView: SearchView) {
        // Change the search text and hint color to white
        val editText = searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        editText.setTextColor(ContextCompat.getColor(this, R.color.white))
        editText.setHintTextColor(ContextCompat.getColor(this, R.color.white))

        // Customize cursor color
        val cursorDrawable = ContextCompat.getDrawable(this, R.drawable.white_cursor)
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(editText, null, cursorDrawable, null, null)

        // Customize search and close icon
        val searchIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
        searchIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_search_white))

        val closeIcon = searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        closeIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_close_white))
    }



}