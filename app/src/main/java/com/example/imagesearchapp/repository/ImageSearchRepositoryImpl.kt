package com.example.imagesearchapp.repository

import com.example.imagesearchapp.data.api.RetrofitApi.api
import com.example.imagesearchapp.data.model.Images
import retrofit2.Response

class ImageSearchRepositoryImpl() : ImageSearchRepository {
    override suspend fun searchImage(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<Images> {
        return api.searchImage(query, sort, page, size)
    }
}