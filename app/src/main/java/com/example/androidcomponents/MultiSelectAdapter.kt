package com.example.androidcomponents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox

class MultiSelectAdapter(private val context: Context, private val items: List<String>) : ArrayAdapter<String>(context, 0, items) {
    // Use a HashSet to keep track of selected items for efficiency
    val selectedItems = HashSet<String>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val checkboxView = convertView as? CheckBox ?: LayoutInflater.from(context).inflate(R.layout.list_item_checkbox, parent, false) as CheckBox
        val item = getItem(position)
        checkboxView.text = item
        checkboxView.isChecked = selectedItems.contains(item)

        checkboxView.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (item != null) {
                    selectedItems.add(item)
                }
            } else {
                selectedItems.remove(item)
            }
        }

        return checkboxView
    }

    fun getSelectedItems(): List<String> {
        return selectedItems.toList()
    }
}

