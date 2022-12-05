package com.example.imagesearchapp.repository

import com.example.imagesearchapp.data.api.RetrofitApi.api
import com.example.imagesearchapp.data.db.ImageSearchDatabase
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.data.model.Images
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class ImageSearchRepositoryImpl(
    private val db : ImageSearchDatabase
) : ImageSearchRepository {
    override suspend fun searchImage(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<Images> {
        return api.searchImage(query, sort, page, size)
    }

    override suspend fun insert(document: Document) {
        db.imageSearchDao().insert(document)
    }

    override suspend fun delete(document: Document) {
        db.imageSearchDao().delete(document)
    }

    override fun getImages(): Flow<List<Document>> {
        return db.imageSearchDao().getImages()
    }

}