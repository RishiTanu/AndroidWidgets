package com.example.androidcomponents

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment

class TopSheetDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.TopSheetDialogTheme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate your layout here
        return inflater.inflate(R.layout.your_top_sheet_layout, container, false)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setLayout(WindowManager.LayoutParams.MATCH_PARENT, 200.dpToPx(requireContext()))
            setGravity(Gravity.TOP)
        }
    }

    // Helper extension function to convert dp to pixels
    fun Int.dpToPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()
}
