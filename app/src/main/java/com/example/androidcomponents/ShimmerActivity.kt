/*
package com.example.androidcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout

class ShimmerActivity : AppCompatActivity() {

    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shimmer)

        shimmerViewContainer = findViewById(R.id.shimmer_view_container)
        recyclerView = findViewById(R.id.recyclerView)

        // Start Shimmer
        shimmerViewContainer.startShimmer()

        // Load data with a delay to simulate network request
        recyclerView.visibility = View.GONE
        Handler(Looper.getMainLooper()).postDelayed({
            // Stop Shimmer and show RecyclerView
            shimmerViewContainer.stopShimmer()
            shimmerViewContainer.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE

            // Set up RecyclerView
            recyclerView.adapter = MyAdapter(listOf("Data 1", "Data 2", "Data 3"))
            recyclerView.layoutManager = LinearLayoutManager(this)
        }, 3000)
    }

    override fun onResume() {
        super.onResume()
        shimmerViewContainer.startShimmer()
    }

    override fun onPause() {
        shimmerViewContainer.stopShimmer()
        super.onPause()
    }
}*/
