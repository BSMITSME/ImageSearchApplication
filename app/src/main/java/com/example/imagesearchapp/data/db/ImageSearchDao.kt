package com.example.imagesearchapp.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.imagesearchapp.data.model.Document
import kotlinx.coroutines.flow.Flow


@Dao
interface ImageSearchDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(document: Document)

    @Delete
    suspend fun delete(document: Document)

    @Query("select * from images")
    fun getImages() : Flow<List<Document>>

}