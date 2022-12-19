package com.example.punkbeers.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Beer(
    @Json(name = "abv")
    val abv: Double,
    @Json(name = "attenuation_level")
    val attenuationLevel: Double,
    @Json(name = "boil_volume")
    val boilVolume: BoilVolume,
    @Json(name = "brewers_tips")
    val brewersTips: String,
    @Json(name = "contributed_by")
    val contributedBy: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "ebc")
    val ebc: Double?,
    @Json(name = "first_brewed")
    val firstBrewed: String,
    @Json(name = "food_pairing")
    val foodPairing: List<String>,
    @Json(name = "ibu")
    val ibu: Double?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "ingredients")
    val ingredients: Ingredients,
    @Json(name = "method")
    val method: Method,
    @Json(name = "name")
    val name: String,
    @Json(name = "ph")
    val ph: Double?,
    @Json(name = "srm")
    val srm: Double?,
    @Json(name = "tagline")
    val tagline: String,
    @Json(name = "target_fg")
    val targetFg: Double,
    @Json(name = "target_og")
    val targetOg: Double,
    @Json(name = "volume")
    val volume: Volume
)