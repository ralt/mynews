package com.ralt.mynews.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NewsDao {
    @Query("SELECT * FROM news ORDER BY timestamp DESC")
    suspend fun getAll(): List<NewsEntity>

    @Upsert
    suspend fun upsertAll(items: List<NewsEntity>)

    @Query("DELETE FROM news WHERE timestamp < :cutoff")
    suspend fun deleteOlderThan(cutoff: Long)
}
