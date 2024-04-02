package com.example.androidcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class ChangePasswordDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_change_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val oldPasswordEditText = view.findViewById<EditText>(R.id.editTextOldPassword)
        val newPasswordEditText = view.findViewById<EditText>(R.id.editTextNewPassword)
        val confirmNewPasswordEditText = view.findViewById<EditText>(R.id.editTextConfirmNewPassword)
        val changePasswordButton = view.findViewById<Button>(R.id.buttonChangePassword)

        changePasswordButton.setOnClickListener {
            val oldPassword = oldPasswordEditText.text.toString()
            val newPassword = newPasswordEditText.text.toString()
            val confirmNewPassword = confirmNewPasswordEditText.text.toString()

            // Basic validation
            if (newPassword != confirmNewPassword) {
                Toast.makeText(context, "New passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Implement your change password logic here

            Toast.makeText(context, "Password changed successfully", Toast.LENGTH_SHORT).show()
            dismiss() // Dismiss the dialog
        }
    }
}
