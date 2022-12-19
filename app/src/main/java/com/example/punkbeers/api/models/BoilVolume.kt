package com.example.punkbeers.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BoilVolume(
    @Json(name = "unit")
    val unit: String,
    @Json(name = "value")
    val value: Int
)