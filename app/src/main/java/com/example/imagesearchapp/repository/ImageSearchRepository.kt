package com.example.imagesearchapp.repository


import androidx.room.Query
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.data.model.Images
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ImageSearchRepository {
    suspend fun searchImage(
        query : String,
        sort : String,
        page : Int,
        size : Int
    ) : Response<Images>

    //Room
    suspend fun insert(document: Document)

    suspend fun delete(document: Document)

    fun getImages() : Flow<List<Document>>

}