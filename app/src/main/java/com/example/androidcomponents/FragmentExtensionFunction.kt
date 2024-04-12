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



/*class MapFragment : Fragment() {
    private lateinit var binding: FragmentMapBinding
    private var isAlreadyInitialized = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isAlreadyInitialized) {
            initializeMapView()
            isAlreadyInitialized = true
        }
    }

    private fun initializeMapView() {
        // All the initialization code that you don't want to execute again
    }
}*/




/*class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showBottomBar(show: Boolean) {
        binding.bottomBar.visibility = if (show) View.VISIBLE else View.GONE
    }
}*/

/*open class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as? DashboardActivity)?.let {
            it.showBottomBar(shouldShowBottomBar())
        }
    }

    open fun shouldShowBottomBar(): Boolean {
        return true  // Default is to show, override in fragments where you don't want to show it
    }
}*/

/*class SplashFragment : BaseFragment() {

    override fun shouldShowBottomBar(): Boolean {
        return false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Your other setup code
    }
}*/
