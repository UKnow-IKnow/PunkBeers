package com.example.punkbeers.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Method(
    @Json(name = "fermentation")
    val fermentation: Fermentation,
    @Json(name = "mash_temp")
    val mashTemp: List<MashTemp>,
    @Json(name = "twist")
    val twist: Any?
)