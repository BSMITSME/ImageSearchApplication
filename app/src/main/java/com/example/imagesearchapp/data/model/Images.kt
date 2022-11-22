package com.example.imagesearchapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Images(
    @Json(name = "documents")
    val documents: List<Document>,
    @Json(name = "meta")
    val meta: Meta
)