package com.example.androidcomponents

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions

fun NavController.navigateSingleTopTo(@IdRes resId: Int, args: Bundle? = null) {
    val currentDestinationId = currentDestination?.id
    if (currentDestinationId != resId) {
        val navOptions = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setPopUpTo(resId, true, false)
            .build()
        navigate(resId, args, navOptions)
    }
}


// Assuming you're in MapFragment and want to navigate to ProfileFragment
//view.findNavController().navigateWithBackStackCheck(R.id.profileFragment)


// Use this in ProfileFragment or another fragment to navigate back to MapFragment
//view.findNavController().navigateWithBackStackCheck(R.id.mapFragment)

/*fun showBottomBar(show: Boolean) {
    activity?.let {
        if (it is YourMainActivity) { // Replace YourMainActivity with your activity class name
            // Ensure the operation is safe with a null check or within a scope where the view is guaranteed to be available
            it.runOnUiThread {
                if (show) {
                    it.binding?.bottomBar?.visibility = View.VISIBLE // Adjust `binding.bottomBar` according to your actual view hierarchy
                } else {
                    it.binding?.bottomBar?.visibility = View.GONE
                }
            }
        }
    }
}*/


