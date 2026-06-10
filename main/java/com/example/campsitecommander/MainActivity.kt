package com.example.campsitecommander

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    // Parallel Arrays for data storage
    val gearItems = arrayOf("Tent", "Marshmallows", "Flashlight")
    val categories = arrayOf("Shelter", "Food", "Safety")
    val quantities = intArrayOf(1, 2, 3)
    val comments = arrayOf("4 people", "For s'mores", "Check batteries")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edtDisplay)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Pass parallel array data to the DetailedActivity via Intent
        val intent = Intent(this, DetailedScreen::class.java)
        intent.putExtra("EXTRA_ITEMS", gearItems)
        intent.putExtra("EXTRA_CATEGORIES", categories)
        intent.putExtra("EXTRA_QUANTITIES", quantities)
        intent.putExtra("EXTRA_COMMENTS", comments)
        startActivity(intent)
    }


    class MainActivity : AppCompatActivity() {

        private var totalPacked = 0 // Tracks the total

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val tvTotalPacked: TextView = findViewById(R.id.tvTotalPacked)
            val btnAddGear: Button = findViewById(R.id.btnAddGear)

            btnAddGear.setOnClickListener {
                totalPacked += 1 // Increment packed items
                tvTotalPacked.text = "Total items packed: $totalPacked"
            }
        }
    }
}

