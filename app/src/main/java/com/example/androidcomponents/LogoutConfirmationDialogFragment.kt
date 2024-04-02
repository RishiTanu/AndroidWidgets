package com.example.androidcomponents

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class LogoutConfirmationDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_logout_confirmation, null)

        builder.setView(view)
            .setPositiveButton("Log Out") { dialog, id ->
                // Handle "Log Out" action here
            }
            .setNegativeButton("Cancel") { dialog, id ->
                // User cancelled the dialog
            }

        return builder.create()
    }
}
