package com.example.campsitecommander

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedScreen : AppCompatActivity() {
    // Campsite Commander object arrays Store  Food Suppliers
    companion object {
        // Parallel Arrays for data storage
        val gearItems = arrayOf("Tent", "Marshmallows", "Flashlight")
        val categories = arrayOf("Shelter", "Food", "Safety")
        val quantities = intArrayOf(1, 2, 3)
        val comments = arrayOf("4 people waterproof", "For s'mores (mega size)", "Check batteries AA")

    }

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edtDisplay)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        // Variable assignments matching your exact styling configuration
        val edtItem = findViewById<EditText>(R.id.edtItem)
        val edtCategory = findViewById<EditText>(R.id.edtCategory)
        val edtQuantity = findViewById<EditText>(R.id.edtQuantity)
        val edtComments = findViewById<EditText>(R.id.edtComments)

        val btnAdd = findViewById<Button>(R.id.btnMain)
        val btnSecond = findViewById<Button>(R.id.btnAddGear)
        val btnExit = findViewById<Button>(R.id.btnBack)

        btnAdd.setOnClickListener {

            val item = edtItem.text.toString()
            val category = edtCategory.text.toString()
            val quantityText = edtQuantity.text.toString()
            val comments = edtComments.text.toString()

            // Error Handling validation with exact match styling
            if (item.isEmpty() || category.isEmpty() ||
                quantityText.isEmpty() || comments.isEmpty()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                Log.e("INPUT_ERROR", "Empty fields detected")
            } else {
                val parsedQuantity = quantityText.toIntOrNull()

                if (parsedQuantity == null || parsedQuantity <= 0) {
                    Toast.makeText(
                        this,
                        "Quantity must be a valid number greater than 0",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.e("INPUT_ERROR", "Invalid quantity format parsed")
                } else {

                    Toast.makeText(this, "Item added successfully!", Toast.LENGTH_SHORT).show()
                    Log.i("SUCCESS", "Item added to parallel arrays")
                    edtItem.text.clear()
                    edtCategory.text.clear()
                    edtQuantity.text.clear()
                    edtComments.text.clear()
                }
            }
        }

        // Back button to return to Main Screen
        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Closes the detailed screen and returns to MainActivity
        }
    }
}