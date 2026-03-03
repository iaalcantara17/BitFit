package com.example.bitfit

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private val entries = mutableListOf<HealthEntry>()
    private var selectedPhotoUri: Uri? = null
    private lateinit var photoPreview: ImageView
    private lateinit var pickImageLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sleepSlider = findViewById<Slider>(R.id.sleepSlider)
        val feelingSlider = findViewById<Slider>(R.id.feelingSlider)
        val notesEditText = findViewById<EditText>(R.id.notesEditText)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val addPhotoButton = findViewById<Button>(R.id.addPhotoButton)
        photoPreview = findViewById(R.id.photoPreview)
        val avgSleepTextView = findViewById<TextView>(R.id.avgSleepTextView)
        val avgFeelingTextView = findViewById<TextView>(R.id.avgFeelingTextView)
        val entriesRecyclerView = findViewById<RecyclerView>(R.id.entriesRecyclerView)

        val adapter = HealthAdapter(entries)
        entriesRecyclerView.adapter = adapter

        pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                selectedPhotoUri = it
                photoPreview.setImageURI(it)
                photoPreview.visibility = View.VISIBLE
            }
        }

        addPhotoButton.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        saveButton.setOnClickListener {
            val sleepHours = sleepSlider.value.toDouble()
            val feeling = feelingSlider.value.toInt()
            val notes = notesEditText.text.toString()
            val date = SimpleDateFormat("MMM d yyyy", Locale.getDefault()).format(Date()).uppercase()

            val entry = HealthEntry(
                sleepHours = sleepHours,
                feeling = feeling,
                notes = notes,
                date = date,
                photoPath = selectedPhotoUri?.toString()
            )

            lifecycleScope.launch(Dispatchers.IO) {
                AppDatabase.getInstance(applicationContext).healthDao().insert(entry)
            }
            
            notesEditText.text.clear()
            sleepSlider.value = 0f
            feelingSlider.value = 0f
            photoPreview.visibility = View.GONE
            selectedPhotoUri = null
        }

        lifecycleScope.launch {
            AppDatabase.getInstance(applicationContext).healthDao().getAll().collect { databaseEntries ->
                adapter.updateEntries(databaseEntries)
                updateDashboard(databaseEntries, avgSleepTextView, avgFeelingTextView)
            }
        }
    }

    private fun updateDashboard(entries: List<HealthEntry>, sleepTv: TextView, feelingTv: TextView) {
        if (entries.isEmpty()) {
            sleepTv.text = "Average hours of sleep: 0 hours"
            feelingTv.text = "Average feeling: 0 / 10"
            return
        }

        val totalSleep = entries.sumOf { it.sleepHours }
        val avgSleep = totalSleep / entries.size
        
        val totalFeeling = entries.sumOf { it.feeling }
        val avgFeeling = totalFeeling / entries.size

        sleepTv.text = "Average hours of sleep: ${String.format("%.1f", avgSleep)} hours"
        feelingTv.text = "Average feeling: $avgFeeling / 10"
    }
}
