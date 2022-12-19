package com.example.punkbeers.api.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Hop(
    @Json(name = "amount")
    val amount: Amount,
    @Json(name = "name")
    val name: String
)