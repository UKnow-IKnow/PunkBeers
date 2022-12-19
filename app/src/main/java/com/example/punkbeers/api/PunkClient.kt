package com.example.punkbeers.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PunkClient {

    val retrofit = Retrofit.Builder().baseUrl("https://api.punkapi.com/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(PunkAPI::class.java)
}