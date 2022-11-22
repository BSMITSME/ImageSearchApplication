package com.example.imagesearchapp.data.api


import com.example.imagesearchapp.util.Contants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object RetrofitApi {
    val okHttpClient : OkHttpClient by lazy {
        val loggingHttpInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder().addInterceptor(loggingHttpInterceptor).build()
    }
    val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    val api : SearchApi by lazy {
        retrofit.create(SearchApi::class.java)
    }


}