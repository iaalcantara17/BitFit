package com.example.bitfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "health_table")
data class HealthEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "sleep_hours") val sleepHours: Double,
    @ColumnInfo(name = "feeling") val feeling: Int,
    @ColumnInfo(name = "notes") val notes: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "photo_path") val photoPath: String? = null
)
