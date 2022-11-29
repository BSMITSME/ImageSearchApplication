package com.example.imagesearchapp.data.model


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "images")
data class Document(
    @Json(name = "collection")
    val collection: String,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "display_sitename")
    val displaySitename: String,
    @PrimaryKey(autoGenerate = false)
    @Json(name = "doc_url")
    val docUrl: String,
    @Json(name = "height")
    val height: Int,
    @ColumnInfo(name = "image_url")
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String,
    @Json(name = "width")
    val width: Int
) : Parcelable