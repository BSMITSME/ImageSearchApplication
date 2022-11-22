package com.example.imagesearchapp.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Document(
    @Json(name = "collection")
    val collection: String,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "display_sitename")
    val displaySitename: String,
    @Json(name = "doc_url")
    val docUrl: String,
    @Json(name = "height")
    val height: Int,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String,
    @Json(name = "width")
    val width: Int
)