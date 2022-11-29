package com.example.imagesearchapp.data.db

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.imagesearchapp.data.model.Document

@Database(
    entities = [Document::class],
    version = 1,
    exportSchema = false
)
abstract class ImageSearchDatabase : RoomDatabase() {
    abstract fun imageSearchDao() : ImageSearchDao

    //Singleton (생성하는데 비용이 많이 들어 중복 방지)
    companion object{
        @Volatile
        private var INSTANCE : ImageSearchDatabase? = null
        private fun buildDatabase(context: Context) : ImageSearchDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                ImageSearchDatabase::class.java,
                "favorite_images"
            ).build()

        fun getInstance(context : Context) : ImageSearchDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
    }
}
