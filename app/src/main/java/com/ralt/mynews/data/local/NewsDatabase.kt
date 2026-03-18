package com.ralt.mynews.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        fun create(context: Context): NewsDatabase =
            Room.databaseBuilder(context, NewsDatabase::class.java, "mynews.db")
                .build()
    }
}
