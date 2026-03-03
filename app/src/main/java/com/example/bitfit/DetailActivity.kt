package com.example.bitfit

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.slider.Slider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val sleepSlider = findViewById<Slider>(R.id.sleepSlider)
        val feelingSlider = findViewById<Slider>(R.id.feelingSlider)
        val notesEditText = findViewById<EditText>(R.id.notesEditText)
        val recordButton = findViewById<Button>(R.id.recordButton)

        recordButton.setOnClickListener {
            val sleepHours = sleepSlider.value.toDouble()
            val feeling = feelingSlider.value.toInt()
            val notes = notesEditText.text.toString()
            val date = SimpleDateFormat("MMM d yyyy", Locale.getDefault()).format(Date()).uppercase()

            val entry = HealthEntry(
                sleepHours = sleepHours,
                feeling = feeling,
                notes = notes,
                date = date
            )

            lifecycleScope.launch(Dispatchers.IO) {
                AppDatabase.getInstance(applicationContext).healthDao().insert(entry)
                finish()
            }
        }
    }
}
