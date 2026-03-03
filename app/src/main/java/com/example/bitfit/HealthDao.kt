package com.example.bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HealthDao {
    @Query("SELECT * FROM health_table ORDER BY id DESC")
    fun getAll(): Flow<List<HealthEntry>>

    @Insert
    suspend fun insert(healthEntry: HealthEntry)

    @Query("DELETE FROM health_table")
    suspend fun deleteAll()
}
