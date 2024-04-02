package com.example.androidcomponents

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {
    private lateinit var loaderDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLoaderDialog()
    }

    protected fun setBottomNavigationBarVisibility(visibility: Boolean) {
        (activity as? MainActivity)?.setBottomNavigationBarVisibility(visibility)
    }


    private fun initLoaderDialog() {
        context?.let {
            loaderDialog = Dialog(it).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setContentView(R.layout.loader_layout) // Assuming you have a layout file `loader_layout.xml` with a ProgressBar
                window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                setCancelable(false)
            }
        }
    }

    protected fun showLoader() {
        loaderDialog.show()
        disableUserInteraction()
    }

    protected fun hideLoader() {
        if (loaderDialog.isShowing) {
            loaderDialog.dismiss()
            enableUserInteraction()
        }
    }

    private fun disableUserInteraction() {
        activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    private fun enableUserInteraction() {
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
}
