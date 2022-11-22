package com.example.imagesearchapp.repository


import com.example.imagesearchapp.data.model.Images
import retrofit2.Response

interface ImageSearchRepository {
    suspend fun searchImage(
        query : String,
        sort : String,
        page : Int,
        size : Int
    ) : Response<Images>
}