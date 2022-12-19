package com.example.punkbeers.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredients(
    @Json(name = "hops")
    val hops: List<Hop>,
    @Json(name = "malt")
    val malt: List<Malt>,
    @Json(name = "yeast")
    val yeast: String
)