package com.example.imagesearchapp.data.api

import com.example.imagesearchapp.data.model.Images
import com.example.imagesearchapp.util.Contants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchApi {
    @GET("v2/search/image")
    @Headers("Authorization: KakaoAK ${API_KEY}")
    suspend fun searchImage(
        @Query("query") query : String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int) : Response<Images>
}