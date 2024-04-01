package com.example.androidcomponents

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3 // The number of tabs

    override fun createFragment(position: Int): Fragment {
        // Return a new fragment instance based on position
        return when (position) {
            0 -> FragmentA()
            1 -> FragmentB()
            2 -> FragmentC()
            else -> FragmentA()
        }
    }
}
